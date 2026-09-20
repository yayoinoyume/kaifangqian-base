#!/usr/bin/env bash
# 开放签（kaifangqian）本地部署 —— 数据库幂等初始化
#
# 依次完成：
#   1. 等待 MySQL 就绪
#   2. 空库时导入 kaifangqian-parent/sql/opensign.sql（152 张表）
#   3. 修正 sys_app_info.app_address（签署跳转链接依赖，缺端口会导致打开报错页）
#   4. 确保 OpenAPI 开发者凭据存在：token 随机生成并写入 .env（不纳入 git）
#   5. 重置管理员密码（前端会先对密码做一次 MD5，故此处同样先 MD5 再走后端算法）
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
  docker exec -i kfq-mysql mysql -uroot -p"${MYSQL_ROOT_PASSWORD}" --force --default-character-set=utf8mb4 "${MYSQL_DATABASE}" < "${SQL_FILE}" 2>/dev/null
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

reset_admin_password() {
  log "重置管理员密码（${ADMIN_USER}）"
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
  log "管理员密码已重置，用户名 ${ADMIN_USER}（密码见 .env）"
}

main() {
  wait_mysql
  import_schema_if_empty
  fix_app_address
  ensure_api_developer
  reset_admin_password
  log "数据库初始化完成"
}

main "$@"
