#!/usr/bin/env bash
# 开放签（kaifangqian）本地部署 —— 数据库幂等初始化
#
# 依次完成：
#   1. 等待 MySQL 就绪
#   2. 空库时导入 kaifangqian-parent/sql/opensign.sql（152 张表）
#   3. 修正 sys_app_info.app_address（签署跳转链接依赖，缺端口会导致打开报错页）
#   4. 确保 OpenAPI 开发者凭据存在：token 随机生成并写入 .env（不纳入 git）
#   5. 管理员密码：仅在首次导入（空库）时设置；已存在则不动，可用 --reset-admin-password 强制重置
#      （前端会先对密码做一次 MD5，故此处同样先 MD5 再走后端算法）
#   6. 短信验证码模式：由 KAIFANGQIAN_SEND_RANDOM_SMS_CODE 决定（false=固定调试码，true=每次随机）
#   7. 生成 OpenAPI RSA2 验签密钥对：私钥留在 .secrets/（不纳入 git），公钥写入 api_developer_manage
#   8. 初始化 OpenAPI 经办人关联与贫困生业务线（租户归属 + 使用者授权），保证开箱可发起签署
#
# 可重复执行，不会覆盖已有业务数据。
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

: "${MYSQL_ROOT_PASSWORD:?缺少 MYSQL_ROOT_PASSWORD}"
MYSQL_DATABASE="${MYSQL_DATABASE:-opensign}"
APP_ADDRESS="${KAIFANGQIAN_APP_ADDRESS:-http://localhost:8806}"
ADMIN_USER="${KAIFANGQIAN_ADMIN_USER:-admin}"
ADMIN_PASSWORD="${KAIFANGQIAN_ADMIN_PASSWORD:-Kfq@2026Poc}"
API_DEV_ID="${KAIFANGQIAN_API_DEVELOPER_ID:-kfq-local-poc-dev}"
API_DEV_NAME="${KAIFANGQIAN_API_DEVELOPER_NAME:-Kaifangqian Local POC}"
SEND_RANDOM_SMS_CODE="${KAIFANGQIAN_SEND_RANDOM_SMS_CODE:-false}"
POVERTY_RE_ID="${KAIFANGQIAN_POVERTY_RE_ID:-kfq-poverty-re-0001}"

# 运行期状态：本次是否真的导入过初始化 SQL（=首次初始化）
DB_FRESH_IMPORT=0
# 是否显式要求重置管理员密码
RESET_ADMIN_PASSWORD=0

mysql_exec() {
  docker exec -i kfq-mysql mysql -uroot -p"${MYSQL_ROOT_PASSWORD}" --default-character-set=utf8mb4 "$@" 2>/dev/null
}

set_env_var() {
  local key="$1" value="$2"
  if grep -q "^${key}=" "${ENV_FILE}"; then
    sed -i "s|^${key}=.*|${key}=${value}|" "${ENV_FILE}"
  else
    printf '%s=%s\n' "${key}" "${value}" >> "${ENV_FILE}"
  fi
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

import_schema_if_empty() {
  local tables
  tables="$(mysql_exec -N -B -e "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='${MYSQL_DATABASE}'" || echo 0)"
  tables="${tables//[^0-9]/}"
  if [ "${tables:-0}" -ge 100 ]; then
    log "数据库已初始化（${tables} 张表），跳过导入"
    return 0
  fi
  [ -f "${SQL_FILE}" ] || fail "缺少初始化 SQL：${SQL_FILE}"
  log "导入初始化 SQL（当前 ${tables:-0} 张表）"
  mysql_exec --force -e "CREATE DATABASE IF NOT EXISTS \`${MYSQL_DATABASE}\` DEFAULT CHARACTER SET utf8mb4" || true
  # 注意：opensign.sql 内含 `CREATE DATABASE opensign` 与 `use opensign;`，
  # 若不剔除，导入会无视 MYSQL_DATABASE 直接写进 opensign 库（曾因此误伤主库）。
  # 这里把这两条语句替换为注释，保证导入目标严格等于 ${MYSQL_DATABASE}。
  sed -e 's|^[[:space:]]*CREATE DATABASE[[:space:]]*`opensign`.*$|-- skipped by init-db.sh: CREATE DATABASE opensign|' \
      -e 's|^[[:space:]]*[Uu][Ss][Ee][[:space:]]*opensign[[:space:]]*;.*$|-- skipped by init-db.sh: use opensign|' \
      "${SQL_FILE}" \
    | docker exec -i kfq-mysql mysql -uroot -p"${MYSQL_ROOT_PASSWORD}" --force --default-character-set=utf8mb4 "${MYSQL_DATABASE}" 2>/dev/null
  DB_FRESH_IMPORT=1
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
    mysql_exec "${MYSQL_DATABASE}" -e "UPDATE sign_re SET id='${POVERTY_RE_ID}' WHERE id=(SELECT id FROM (SELECT id FROM sign_re ORDER BY create_time LIMIT 1) t)"
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

main() {
  while [ $# -gt 0 ]; do
    case "$1" in
      --reset-admin-password) RESET_ADMIN_PASSWORD=1; shift ;;
      *) fail "未知参数：$1（可用：--reset-admin-password）" ;;
    esac
  done
  wait_mysql
  import_schema_if_empty
  fix_app_address
  ensure_api_developer
  ensure_api_keypair
  ensure_operator_and_business_line
  configure_sms_code_mode
  ensure_admin_password
  log "数据库初始化完成"
}

main "$@"
