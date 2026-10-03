#!/usr/bin/env bash
# 资助审批电子签章系统（kaifangqian）本地部署 —— 数据库幂等初始化
#
# 依次完成：
#   1. 等待 MySQL 就绪
#   2. 空库（0 张表）时导入 kaifangqian-parent/sql/opensign.sql；非空库拒绝导入，
#      确需重建必须显式传 --force-init（导入前强制 mysqldump 备份）
#   3. 修正 sys_app_info.app_address（签署跳转链接依赖，缺端口会导致打开报错页）
#   4. 确保 OpenAPI 开发者凭据存在：token 随机生成并写入 .env（不纳入 git）
#   5. 管理员密码：仅在首次导入（空库）时设置；已存在则不动，可用 --reset-admin-password 强制重置
#      （前端会先对密码做一次 MD5，故此处同样先 MD5 再走后端算法）
#   6. 短信验证码模式：由 KAIFANGQIAN_SEND_RANDOM_SMS_CODE 决定（false=固定调试码，true=每次随机）
#   7. 生成 OpenAPI RSA2 验签密钥对：私钥留在 .secrets/（不纳入 git），公钥写入 api_developer_manage
#   8. 初始化 OpenAPI 经办人关联与贫困生业务线（租户归属 + 使用者授权），保证开箱可发起签署
#
# 可重复执行，不会覆盖已有业务数据。
# 参数：--reset-admin-password 强制重置管理员密码；--force-init 允许在非空库上导入（危险）
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/../.." && pwd)"
ENV_FILE="${SCRIPT_DIR}/.env"
SQL_FILE="${PROJECT_ROOT}/kaifangqian-parent/sql/opensign.sql"
MAVEN_IMAGE="${KFQ_MAVEN_IMAGE:-maven:3.9-eclipse-temurin-8}"

fail() { printf '\n[init-db][ERROR] %s\n' "$*" >&2; exit 1; }
log()  { printf '\n[init-db] %s\n' "$*"; }

[ -f "${ENV_FILE}" ] || fail "缺少 ${ENV_FILE}，请先复制 .env.example 或直接运行 up.sh"
# shellcheck disable=SC1090
set -a; . "${ENV_FILE}"; set +a

set_env_var() {
  local key="$1" value="$2"
  if grep -q "^${key}=" "${ENV_FILE}"; then
    sed -i "s|^${key}=.*|${key}=${value}|" "${ENV_FILE}"
  else
    printf '%s=%s\n' "${key}" "${value}" >> "${ENV_FILE}"
  fi
}

# 口令必须显式配置或由脚本随机生成，禁止弱默认值；生成的随机口令回写 .env（不纳入 git）
ensure_secret() {
  local key="$1"
  local current="${!key:-}"
  if [ -z "${current}" ]; then
    current="$(openssl rand -hex 16)"
    set_env_var "${key}" "${current}"
    printf -v "${key}" '%s' "${current}"
    log "已生成 ${key} 并写入 ${ENV_FILE}（不纳入 git）"
  fi
}

ensure_secret MYSQL_ROOT_PASSWORD
ensure_secret REDIS_PASSWORD
ensure_secret POWERJOB_DB_PASSWORD
ensure_secret KAIFANGQIAN_ADMIN_PASSWORD
ensure_secret KFQ_LOCAL_CA_PASSWORD

MYSQL_DATABASE="${MYSQL_DATABASE:-opensign}"
APP_ADDRESS="${KAIFANGQIAN_APP_ADDRESS:-http://localhost:8806}"
ADMIN_USER="${KAIFANGQIAN_ADMIN_USER:-admin}"
ADMIN_PASSWORD="${KAIFANGQIAN_ADMIN_PASSWORD:?缺少 KAIFANGQIAN_ADMIN_PASSWORD}"
API_DEV_ID="${KAIFANGQIAN_API_DEVELOPER_ID:-kfq-local-poc-dev}"
API_DEV_NAME="${KAIFANGQIAN_API_DEVELOPER_NAME:-Kaifangqian Local POC}"
SEND_RANDOM_SMS_CODE="${KAIFANGQIAN_SEND_RANDOM_SMS_CODE:-true}"
ALLOW_INSECURE_SMS_DEBUG="${KAIFANGQIAN_ALLOW_INSECURE_SMS_DEBUG:-false}"
POVERTY_RE_ID="${KAIFANGQIAN_POVERTY_RE_ID:-kfq-poverty-re-0001}"
POWERJOB_DB_USER="${POWERJOB_DB_USER:-kfq_powerjob}"
POWERJOB_DB_PASSWORD="${POWERJOB_DB_PASSWORD:?缺少 POWERJOB_DB_PASSWORD}"
LOCAL_CA_PASSWORD="${KFQ_LOCAL_CA_PASSWORD:?缺少 KFQ_LOCAL_CA_PASSWORD}"

# 运行期状态：本次是否真的导入过初始化 SQL（=首次初始化）
DB_FRESH_IMPORT=0
# 是否显式要求重置管理员密码
RESET_ADMIN_PASSWORD=0
# 是否允许在非空库上强制导入（危险操作，需 --force-init 显式开启）
FORCE_INIT=0

mysql_exec() {
  docker exec -i kfq-mysql mysql -uroot -p"${MYSQL_ROOT_PASSWORD}" --default-character-set=utf8mb4 "$@" 2>/dev/null
}

wait_mysql() {
  log "等待 MySQL 就绪"
  for _ in $(seq 1 60); do
    if docker exec kfq-mysql mysqladmin ping -uroot -p"${MYSQL_ROOT_PASSWORD}" --silent >/dev/null 2>&1; then
      return 0
    fi
    sleep 3
  done
  fail "MySQL 在 180 秒内未就绪"
}

backup_database() {
  local backup_dir="${SCRIPT_DIR}/backups"
  mkdir -p "${backup_dir}"
  chmod 700 "${backup_dir}" 2>/dev/null || true
  local backup_file="${backup_dir}/pre-init-${MYSQL_DATABASE}-$(date +%Y%m%d-%H%M%S).sql"
  log "导入前备份数据库到 ${backup_file}"
  if ! docker exec kfq-mysql mysqldump -uroot -p"${MYSQL_ROOT_PASSWORD}" --single-transaction --routines --events --databases "${MYSQL_DATABASE}" > "${backup_file}"; then
    rm -f "${backup_file}"
    fail "数据库备份失败，已中止导入"
  fi
  if [ ! -s "${backup_file}" ]; then
    rm -f "${backup_file}"
    fail "数据库备份为空，已中止导入"
  fi
  chmod 600 "${backup_file}" 2>/dev/null || true
  log "备份完成（$(wc -c < "${backup_file}") 字节）"
}

assert_schema_loaded() {
  local tables expected
  tables="$(mysql_exec -N -B -e "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='${MYSQL_DATABASE}'" || echo 0)"
  tables="${tables//[^0-9]/}"
  # 期望表数从初始化 SQL 动态统计 CREATE TABLE，避免 SQL 增删表后写死数字误报阻断
  expected="$(grep -ciE '^[[:space:]]*CREATE[[:space:]]+TABLE' "${SQL_FILE}" || true)"
  expected="${expected//[^0-9]/}"
  if [ "${expected:-0}" -gt 0 ] && [ "${tables:-0}" -lt "${expected:-0}" ]; then
    fail "导入后表数量异常（${tables:-0} < SQL 中的 CREATE TABLE 数 ${expected}），请检查导入日志或用备份回滚"
  fi
  local t cnt
  for t in sys_user sign_re api_developer_manage sys_app_info sys_config; do
    cnt="$(mysql_exec -N -B -e "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='${MYSQL_DATABASE}' AND table_name='${t}'" || echo 0)"
    cnt="${cnt//[^0-9]/}"
    if [ "${cnt:-0}" -lt 1 ]; then
      fail "导入后缺少关键表 ${t}"
    fi
  done
}

import_schema_if_empty() {
  local tables
  tables="$(mysql_exec -N -B -e "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='${MYSQL_DATABASE}'" || echo 0)"
  tables="${tables//[^0-9]/}"
  if [ "${tables:-0}" -gt 0 ]; then
    if [ "${FORCE_INIT}" != "1" ]; then
      fail "目标库 ${MYSQL_DATABASE} 非空（${tables} 张表），已拒绝自动导入以免 DROP TABLE 造成数据丢失。确需重建请先备份并显式传入 --force-init"
    fi
    log "警告：--force-init 已开启，将对非空库 ${MYSQL_DATABASE}（${tables} 张表）执行导入"
    backup_database
  fi
  [ -f "${SQL_FILE}" ] || fail "缺少初始化 SQL：${SQL_FILE}"

  # 过滤 dump 自带的建库/切库语句，并再次扫描，出现任何库级语句立即终止
  local filtered
  filtered="$(mktemp)"
  sed -e 's|^[[:space:]]*CREATE DATABASE.*$|-- skipped by init-db.sh: CREATE DATABASE|' \
      -e 's|^[[:space:]]*[Uu][Ss][Ee][[:space:]].*;.*$|-- skipped by init-db.sh: USE|' \
      -e 's|^[[:space:]]*DROP DATABASE.*$|-- skipped by init-db.sh: DROP DATABASE|' \
      -e 's|^[[:space:]]*ALTER DATABASE.*$|-- skipped by init-db.sh: ALTER DATABASE|' \
      "${SQL_FILE}" > "${filtered}"
  if grep -nEi '^[[:space:]]*(CREATE|DROP|ALTER)[[:space:]]+DATABASE|^[[:space:]]*USE[[:space:]]' "${filtered}"; then
    rm -f "${filtered}"
    fail "初始化 SQL 中仍存在库级语句（CREATE/DROP/ALTER DATABASE 或 USE），已中止导入"
  fi

  log "导入初始化 SQL（当前 ${tables:-0} 张表）"
  docker exec -i kfq-mysql mysql -uroot -p"${MYSQL_ROOT_PASSWORD}" \
    --default-character-set=utf8mb4 "${MYSQL_DATABASE}" < "${filtered}"
  rm -f "${filtered}"
  DB_FRESH_IMPORT=1
  assert_schema_loaded
  log "导入完成（$(mysql_exec -N -B -e "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='${MYSQL_DATABASE}'") 张表）"
}

fix_app_address() {
  log "修正 sys_app_info.app_address → ${APP_ADDRESS}"
  mysql_exec "${MYSQL_DATABASE}" <<SQL
UPDATE sys_app_info SET app_address = '${APP_ADDRESS}' WHERE app_code = 'opensign_0001' AND app_address = 'http://localhost';
UPDATE sys_app_info SET app_address = CONCAT('${APP_ADDRESS}', SUBSTRING(app_address, 17)) WHERE app_code = 'opensign_0001' AND app_address LIKE 'http://localhost/%';
SQL
}

ensure_api_developer() {
  local token="${KAIFANGQIAN_API_TOKEN:-}"
  if [ -z "${token}" ]; then
    token="$(openssl rand -hex 32)"
    set_env_var KAIFANGQIAN_API_TOKEN "${token}"
    log "已生成新的 OpenAPI token 并写入 ${ENV_FILE}（不纳入 git）"
  fi
  log "写入 api_developer_manage 凭据（id=${API_DEV_ID}）"
  mysql_exec "${MYSQL_DATABASE}" <<SQL
INSERT INTO api_developer_manage (id, developer_name, token, status, tenant_id, create_time)
VALUES ('${API_DEV_ID}', '${API_DEV_NAME}', '${token}', 1, '', NOW())
ON DUPLICATE KEY UPDATE developer_name = VALUES(developer_name), token = VALUES(token), status = 1;
SQL
}

ensure_operator_and_business_line() {
  # OpenAPI 的 operatorAccount 需要一条 api_relation_link 才能解析成系统账号（否则报"账号不存在"）；
  # 业务线还需要归属租户 + 使用者授权（否则报"发起方企业/经办人无权使用该业务线"）。

  local tenant_user_id tenant_id
  tenant_user_id="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT id FROM sys_tenant_user WHERE user_id=(SELECT id FROM sys_user WHERE username='${ADMIN_USER}' LIMIT 1) ORDER BY create_time LIMIT 1" || true)"
  tenant_user_id="$(printf '%s' "${tenant_user_id}" | head -n 1 | tr -d '[:space:]')"
  if [ -z "${tenant_user_id}" ]; then
    log "未找到 ${ADMIN_USER} 的租户记录，跳过经办人关联初始化"
    return 0
  fi
  tenant_id="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT tenant_id FROM sys_tenant_user WHERE id='${tenant_user_id}' LIMIT 1" || true)"
  tenant_id="$(printf '%s' "${tenant_id}" | head -n 1 | tr -d '[:space:]')"

  log "初始化 OpenAPI 经办人关联（${ADMIN_USER}）与业务线（${POVERTY_RE_ID}）"

  local api_token="${KAIFANGQIAN_API_TOKEN:-}"
  if [ -n "${api_token}" ]; then
    mysql_exec "${MYSQL_DATABASE}" <<SQL
UPDATE api_developer_manage SET tenant_id='${tenant_id}' WHERE id='${API_DEV_ID}';
DELETE FROM api_relation_link WHERE token='${api_token}' AND external_account='${ADMIN_USER}';
INSERT INTO api_relation_link (id,type,token,external_account,system_id,create_time)
VALUES (UUID(),'USER','${api_token}','${ADMIN_USER}','${tenant_user_id}',NOW());
SQL
  fi

  local re_exists
  re_exists="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT COUNT(*) FROM sign_re WHERE id='${POVERTY_RE_ID}'" || echo 0)"
  re_exists="${re_exists//[^0-9]/}"
  if [ "${re_exists:-0}" -eq 0 ]; then
    # 不再重命名既有业务线主键（会破坏既有引用），改为复制一条模板业务线为新行
    local template_id
    template_id="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT id FROM sign_re WHERE id='1' LIMIT 1" || true)"
    template_id="$(printf '%s' "${template_id}" | head -n 1 | tr -d '[:space:]')"
    if [ -z "${template_id}" ]; then
      template_id="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT id FROM sign_re ORDER BY create_time LIMIT 1" || true)"
      template_id="$(printf '%s' "${template_id}" | head -n 1 | tr -d '[:space:]')"
    fi
    if [ -z "${template_id}" ]; then
      fail "sign_re 中没有任何模板业务线，无法初始化 ${POVERTY_RE_ID}；请先通过系统创建业务线"
    fi
    log "业务线 ${POVERTY_RE_ID} 不存在，从模板 ${template_id} 复制新业务线（不修改既有记录）"
    mysql_exec "${MYSQL_DATABASE}" <<SQL
CREATE TEMPORARY TABLE _kfq_re_template AS SELECT * FROM sign_re WHERE id='${template_id}';
UPDATE _kfq_re_template SET id='${POVERTY_RE_ID}', name='贫困生资助业务线';
INSERT INTO sign_re SELECT * FROM _kfq_re_template;
DROP TEMPORARY TABLE _kfq_re_template;
SQL
  fi

  mysql_exec "${MYSQL_DATABASE}" <<SQL
UPDATE sign_re SET sys_tenant_id='${tenant_id}',
                   sys_user_id=(SELECT id FROM sys_user WHERE username='${ADMIN_USER}' LIMIT 1),
                   sys_account_id=(SELECT id FROM sys_user WHERE username='${ADMIN_USER}' LIMIT 1),
                   personal_sign_auth='not_required',
                   status=1, error_status=2, delete_flag=0
 WHERE id='${POVERTY_RE_ID}';
SQL

  local auth_cnt
  auth_cnt="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT COUNT(*) FROM sign_re_auth WHERE sign_re_id='${POVERTY_RE_ID}' AND auth_type=2 AND delete_flag=0" || echo 0)"
  auth_cnt="${auth_cnt//[^0-9]/}"
  if [ "${auth_cnt:-0}" -eq 0 ]; then
    mysql_exec "${MYSQL_DATABASE}" -e "INSERT INTO sign_re_auth (id,sign_re_id,auth_type,user_id,delete_flag,create_by,create_time,tenant_id) VALUES (UUID(),'${POVERTY_RE_ID}',2,NULL,0,'${ADMIN_USER}',NOW(),'${tenant_id}')"
  fi
}

configure_sms_code_mode() {
  # send_message=false -> 后端用 CommonConstants.DEFAULTCODE（即 123456）作固定验证码，调试期免捞日志
  # send_message=true  -> 每次 RandomUtil.randomNumbers(6) 随机生成
  local want="false"
  case "$(printf '%s' "${SEND_RANDOM_SMS_CODE}" | tr '[:upper:]' '[:lower:]')" in
    1|true|yes|on) want="true" ;;
  esac
  # 固定调试码属于不安全模式，必须显式声明接受风险才允许
  if [ "${want}" = "false" ]; then
    case "$(printf '%s' "${ALLOW_INSECURE_SMS_DEBUG}" | tr '[:upper:]' '[:lower:]')" in
      1|true|yes|on)
        log "警告：短信验证码使用固定调试码（KAIFANGQIAN_ALLOW_INSECURE_SMS_DEBUG=true），仅限构建调试" ;;
      *)
        fail "KAIFANGQIAN_SEND_RANDOM_SMS_CODE=false 属不安全调试模式；如确需固定验证码，请显式设置 KAIFANGQIAN_ALLOW_INSECURE_SMS_DEBUG=true" ;;
    esac
  fi

  local cnt
  cnt="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT COUNT(*) FROM sys_config WHERE type='send_message'" || echo 0)"
  cnt="${cnt//[^0-9]/}"
  if [ "${cnt:-0}" -eq 0 ]; then
    mysql_exec "${MYSQL_DATABASE}" -e "INSERT INTO sys_config (id,name,type,value,create_by,create_time,update_by,update_time) VALUES ('5cpp6af-1eff-ad09-4fb4-o93b22d61607','是否发送短信','send_message','${want}',NULL,NOW(),'admin',NOW())"
  else
    mysql_exec "${MYSQL_DATABASE}" -e "UPDATE sys_config SET value='${want}' WHERE type='send_message'"
  fi

  if [ "${want}" = "true" ]; then
    log "短信验证码模式：每次随机 6 位（生产模式；需接入真实短信网关，否则用户收不到）"
  else
    log "短信验证码模式：固定调试码（后端 DEFAULTCODE，通常 123456）——仅供构建调试，生产必须改为随机"
  fi
}

ensure_api_keypair() {
  local secrets_dir="${SCRIPT_DIR}/.secrets"
  local private_key="${secrets_dir}/api-client-private.pem"
  mkdir -p "${secrets_dir}"
  chmod 700 "${secrets_dir}" 2>/dev/null || true
  if [ ! -f "${private_key}" ]; then
    log "生成 OpenAPI 客户端 RSA 私钥（仅本地保存，不纳入 git）"
    openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -out "${private_key}" 2>/dev/null \
      || fail "RSA 私钥生成失败（需要 openssl）"
    chmod 600 "${private_key}"
  fi
  local public_key_b64
  public_key_b64="$(openssl rsa -in "${private_key}" -pubout -outform DER 2>/dev/null | base64 -w0)"
  [ -n "${public_key_b64}" ] || fail "公钥生成失败"
  mysql_exec "${MYSQL_DATABASE}" <<SQL
UPDATE api_developer_manage SET public_key = '${public_key_b64}' WHERE id = '${API_DEV_ID}';
SQL
  log "开发者验签公钥已写入数据库（私钥路径：${private_key}）"
}

ensure_admin_password() {
  if [ "${RESET_ADMIN_PASSWORD}" != "1" ] && [ "${DB_FRESH_IMPORT}" != "1" ]; then
    log "管理员 ${ADMIN_USER} 已存在，保持现有密码不动（如需强制重置：./init-db.sh --reset-admin-password）"
    return 0
  fi
  if [ "${RESET_ADMIN_PASSWORD}" = "1" ] && [ "${DB_FRESH_IMPORT}" != "1" ]; then
    log "按显式要求重置管理员密码（${ADMIN_USER}）"
  else
    log "首次初始化，设置管理员密码（${ADMIN_USER}）"
  fi
  local salt
  salt="$(mysql_exec -N -B "${MYSQL_DATABASE}" -e "SELECT IFNULL(salt,'') FROM sys_user WHERE username='${ADMIN_USER}' LIMIT 1")"
  if [ -z "${salt}" ]; then
    log "未找到用户 ${ADMIN_USER} 或其 salt 为空，跳过密码重置"
    return 0
  fi
  local md5_password encrypted
  md5_password="$(printf '%s' "${ADMIN_PASSWORD}" | md5sum | awk '{print $1}')"
  local work
  work="$(mktemp -d)"
  cat > "${work}/GenPwd.java" <<'JAVA'
import com.kaifangqian.utils.PasswordUtil;

public class GenPwd {
    public static void main(String[] args) throws Exception {
        System.out.println(PasswordUtil.encrypt(args[0], args[1], args[2]));
    }
}
JAVA
  encrypted="$(docker run --rm \
    -v "${PROJECT_ROOT}/kaifangqian-parent/kaifangqian-tools/libs:/libs:ro" \
    -v "${work}:/work" \
    -w /work \
    -e GEN_USER="${ADMIN_USER}" \
    -e GEN_PWD="${md5_password}" \
    -e GEN_SALT="${salt}" \
    "${MAVEN_IMAGE}" \
    bash -c 'javac -cp /libs/core-1.1-SNAPSHOT.jar:/libs/common-1.1-SNAPSHOT.jar GenPwd.java >/dev/null 2>&1 && java -cp /libs/core-1.1-SNAPSHOT.jar:/libs/common-1.1-SNAPSHOT.jar:/work GenPwd "$GEN_USER" "$GEN_PWD" "$GEN_SALT"')"
  if [ -z "${encrypted}" ]; then
    fail "管理员密码密文生成失败"
  fi
  mysql_exec "${MYSQL_DATABASE}" <<SQL
UPDATE sys_user SET password = '${encrypted}', status = 1, delete_flag = 0 WHERE username = '${ADMIN_USER}';
SQL
  log "管理员密码已写入，用户名 ${ADMIN_USER}（密码见 .env）"
}

# SQL/shell 值安全校验：拒绝会破坏单引号包裹 SQL 字符串或 shell 参数的字符。
# 自动生成的 hex 口令/token（ensure_secret / openssl rand）只含 [0-9a-f]，天然通过。
validate_sql_safe_value() {
  local name="$1" value="${!1:-}"
  case "${value}" in
    *"'"*|*'"'*|*"\\"*|*$'\n'*|*$'\r'*)
      fail "${name} 含非法字符（不允许单引号、双引号、反斜杠、换行），请修改后再初始化"
      ;;
  esac
}

check_env_security() {
  # .env 权限收紧，避免同机其他用户读取数据库/管理员口令
  local perms
  perms="$(stat -c '%a' "${ENV_FILE}" 2>/dev/null || echo '')"
  if [ -n "${perms}" ] && [ "${perms}" != "600" ] && [ "${perms}" != "400" ]; then
    fail "请先收紧 ${ENV_FILE} 权限（当前 ${perms}，要求 600）"
  fi
  # 默认/弱口令直接拒绝启动；KFQ_LOCAL_CA_PASSWORD 亦纳入弱口令黑名单
  local weak='123456 password root admin KfqPoc2026Root KfqPoc2026Redis Kfq@2026Poc'
  local name value w
  for name in MYSQL_ROOT_PASSWORD REDIS_PASSWORD KAIFANGQIAN_ADMIN_PASSWORD POWERJOB_DB_PASSWORD KFQ_LOCAL_CA_PASSWORD; do
    value="${!name:-}"
    if [ -z "${value}" ]; then
      fail "${name} 未配置（生产必须显式配置强口令）"
    fi
    validate_sql_safe_value "${name}"
    for w in ${weak}; do
      if [ "${value}" = "${w}" ]; then
        fail "${name} 使用了弱口令/默认口令，请更换后再初始化"
      fi
    done
  done
  # 其他会被拼入 SQL 的用户可控值：同样做字符安全校验
  # （KAIFANGQIAN_API_TOKEN 为空时由脚本生成 hex，天然安全；其余为可选默认值）
  for name in KAIFANGQIAN_API_TOKEN KAIFANGQIAN_APP_ADDRESS KAIFANGQIAN_ADMIN_USER \
              KAIFANGQIAN_API_DEVELOPER_ID KAIFANGQIAN_API_DEVELOPER_NAME \
              KAIFANGQIAN_POVERTY_RE_ID POWERJOB_DB_USER MYSQL_DATABASE; do
    validate_sql_safe_value "${name}"
  done
}

ensure_powerjob_db_user() {
  log "确保 PowerJob 专用数据库账号（${POWERJOB_DB_USER}，最小权限，不使用 root）"
  mysql_exec -e "CREATE USER IF NOT EXISTS '${POWERJOB_DB_USER}'@'%' IDENTIFIED BY '${POWERJOB_DB_PASSWORD}'"
  mysql_exec -e "ALTER USER '${POWERJOB_DB_USER}'@'%' IDENTIFIED BY '${POWERJOB_DB_PASSWORD}'"
  mysql_exec -e "GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, INDEX, REFERENCES, DROP, CREATE TEMPORARY TABLES, LOCK TABLES ON \`${MYSQL_DATABASE}\`.* TO '${POWERJOB_DB_USER}'@'%'"
  mysql_exec -e "FLUSH PRIVILEGES"
}

ensure_local_ca_password() {
  # 已有 PFX 若仍使用旧固定口令 123456，则一次性迁移到 .env 中的新口令；绝不删除重建证书。
  local ca_rel="${KFQ_LOCAL_CA_DIR:-/app/storage/local-ca}"
  ca_rel="${ca_rel#/app/storage/}"
  local pfx="/data/${ca_rel}/kfq-local-signer.pfx"
  local ca_image="${KFQ_CA_IMAGE:-eclipse-temurin:8-jre}"
  if ! docker volume inspect kfq-storage >/dev/null 2>&1; then
    log "未找到数据卷 kfq-storage，跳过本地签名证书口令检查"
    return 0
  fi
  if ! docker run --rm -v kfq-storage:/data --entrypoint sh "${ca_image}" -c "test -f '${pfx}'" >/dev/null 2>&1; then
    log "本地签名证书尚未生成，首次签署时使用新口令创建"
    return 0
  fi
  if docker run --rm -v kfq-storage:/data --entrypoint sh "${ca_image}" -c "keytool -list -keystore '${pfx}' -storepass '${LOCAL_CA_PASSWORD}' >/dev/null 2>&1"; then
    log "本地签名证书口令校验通过"
    return 0
  fi
  if docker run --rm -v kfq-storage:/data --entrypoint sh "${ca_image}" -c "keytool -list -keystore '${pfx}' -storepass '123456' >/dev/null 2>&1"; then
    log "检测到旧固定口令证书，迁移到新口令（原子替换，不重建 CA）"
    docker run --rm -v kfq-storage:/data --entrypoint sh "${ca_image}" -c "
      set -e
      keytool -importkeystore -noprompt \
        -srckeystore '${pfx}' -srcstoretype PKCS12 -srcstorepass '123456' \
        -destkeystore '${pfx}.new' -deststoretype PKCS12 -deststorepass '${LOCAL_CA_PASSWORD}' -destkeypass '${LOCAL_CA_PASSWORD}'
      chmod 600 '${pfx}.new'
      mv -f '${pfx}.new' '${pfx}'
    " || fail "本地签名证书口令迁移失败，请人工处理（不要删除证书）"
    log "本地签名证书口令迁移完成"
  else
    fail "本地签名证书无法用新口令或旧固定口令打开，拒绝重建；请人工确认 ${pfx}"
  fi
}

main() {
  while [ $# -gt 0 ]; do
    case "$1" in
      --reset-admin-password) RESET_ADMIN_PASSWORD=1; shift ;;
      --force-init) FORCE_INIT=1; shift ;;
      *) fail "未知参数：$1（可用：--reset-admin-password、--force-init）" ;;
    esac
  done
  check_env_security
  wait_mysql
  import_schema_if_empty
  fix_app_address
  ensure_api_developer
  ensure_api_keypair
  ensure_operator_and_business_line
  ensure_powerjob_db_user
  configure_sms_code_mode
  ensure_local_ca_password
  ensure_admin_password
  log "数据库初始化完成"
}

main "$@"
