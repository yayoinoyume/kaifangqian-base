#!/usr/bin/env bash
# 开放签（kaifangqian）本地私有化部署 —— 一键拉起
#
# 用法：
#   ./up.sh            # 产物存在则直接拉起；缺失则自动全量构建
#   ./up.sh --build    # 先强制全量构建，再拉起
#   ./up.sh --no-build # 不做构建检查，直接拉起（产物缺失会报错）
#
# 执行内容：
#   1. 准备 .env（不存在时从 .env.example 复制）
#   2. 确保 kfq-net 网络与 4 个数据卷存在（卷 external，compose down 不会删）
#   3. 校验/构建 ./build/ 产物
#   4. docker compose up -d，等待 5 个容器健康
#   5. init-db.sh 做幂等数据库初始化
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="${SCRIPT_DIR}/docker-compose.yml"
ENV_FILE="${SCRIPT_DIR}/.env"
ENV_EXAMPLE="${SCRIPT_DIR}/.env.example"
BUILD_DIR="${SCRIPT_DIR}/build"
WAIT_TIMEOUT="${KFQ_WAIT_TIMEOUT:-600}"

fail() { printf '\n[up][ERROR] %s\n' "$*" >&2; exit 1; }
log()  { printf '\n[up] %s\n' "$*"; }

compose() { docker compose -f "${COMPOSE_FILE}" --env-file "${ENV_FILE}" "$@"; }

prepare_env() {
  if [ ! -f "${ENV_FILE}" ]; then
    cp "${ENV_EXAMPLE}" "${ENV_FILE}"
    log "已根据 .env.example 生成 .env（含本地凭据，不纳入 git）"
  fi
}

ensure_network_and_volumes() {
  log "确保网络与数据卷存在"
  docker network inspect kfq-net >/dev/null 2>&1 || docker network create kfq-net >/dev/null
  for v in kfq-mysql-data kfq-redis-data kfq-storage kfq-file-storage; do
    docker volume inspect "${v}" >/dev/null 2>&1 || docker volume create "${v}" >/dev/null
  done
}

artifacts_missing() {
  [ ! -f "${BUILD_DIR}/kaifangqian.jar" ] \
    || [ ! -f "${BUILD_DIR}/powerjob-server.jar" ] \
    || [ ! -d "${BUILD_DIR}/webroot" ]
}

ensure_artifacts() {
  local mode="$1"
  case "${mode}" in
    always)   "${SCRIPT_DIR}/build.sh" all ;;
    never)    artifacts_missing && fail "构建产物缺失（${BUILD_DIR}），请先运行 ./build.sh" ;;
    auto)
      if artifacts_missing; then
        log "构建产物缺失，自动执行全量构建"
        "${SCRIPT_DIR}/build.sh" all
      fi
      ;;
  esac
}

wait_healthy() {
  log "等待容器健康（后端实测约 250 秒，最长 ${WAIT_TIMEOUT} 秒）"
  local deadline=$((SECONDS + WAIT_TIMEOUT))
  local services="kfq-mysql kfq-redis kfq-powerjob kfq-api kfq-web"
  while [ "${SECONDS}" -lt "${deadline}" ]; do
    local all_ok=1 summary=""
    for name in ${services}; do
      local state
      state="$(docker inspect -f '{{if .State.Health}}{{.State.Health.Status}}{{else}}{{.State.Status}}{{end}}' "${name}" 2>/dev/null || echo missing)"
      summary="${summary}${name}=${state} "
      [ "${state}" = "healthy" ] || all_ok=0
    done
    if [ "${all_ok}" -eq 1 ]; then
      log "全部容器健康：${summary}"
      return 0
    fi
    sleep 10
  done
  fail "等待超时，当前状态：$(for n in kfq-mysql kfq-redis kfq-powerjob kfq-api kfq-web; do printf '%s=%s ' "$n" "$(docker inspect -f '{{if .State.Health}}{{.State.Health.Status}}{{else}}{{.State.Status}}{{end}}' "$n" 2>/dev/null || echo missing)"; done)"
}

main() {
  command -v docker >/dev/null 2>&1 || fail "未找到 docker 命令"
  local build_mode="auto"
  while [ $# -gt 0 ]; do
    case "$1" in
      --build)    build_mode="always"; shift ;;
      --no-build) build_mode="never"; shift ;;
      *)          fail "未知参数：$1" ;;
    esac
  done
  prepare_env
  ensure_network_and_volumes
  ensure_artifacts "${build_mode}"
  log "启动容器"
  compose up -d
  wait_healthy
  "${SCRIPT_DIR}/init-db.sh"
  log "完成，入口：${KAIFANGQIAN_APP_ADDRESS:-http://localhost:8806/}"
}

main "$@"
