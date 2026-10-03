#!/usr/bin/env bash
# 资助审批电子签章系统（kaifangqian）本地私有化部署 —— 构建脚本
#
# 用法：
#   ./build.sh              # 全量构建：后端 + PowerJob + 5 个前端 + 产物组装
#   ./build.sh backend      # 仅编译后端 jar
#   ./build.sh powerjob     # 仅编译 PowerJob Server jar
#   ./build.sh frontend     # 仅构建 5 个前端并组装 webroot
#
# 说明：
#   - 所有编译都在 Docker 容器内完成，宿主机无需 JDK/Maven/Node。
#   - 构建产物统一放在 ./build/，该目录不纳入 git。
#   - 后端编译依赖内网镜像加速（maven-settings.xml 指向阿里云中央仓库）。
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/../.." && pwd)"
BUILD_DIR="${SCRIPT_DIR}/build"
MAVEN_SETTINGS="${SCRIPT_DIR}/maven-settings.xml"
M2_DIR="${KFQ_M2_DIR:-${HOME}/.cache/kfq-m2}"
CACHE_DIR="${KFQ_CACHE_DIR:-${HOME}/.cache/kfq-deps}"
POWERJOB_VERSION="${POWERJOB_VERSION:-4.0.1}"
MAVEN_IMAGE="${KFQ_MAVEN_IMAGE:-maven:3.9-eclipse-temurin-8}"
NODE_IMAGE="${KFQ_NODE_IMAGE:-node:16-bullseye}"
PNPM_VERSION="${KFQ_PNPM_VERSION:-8.15.9}"
GIT_PROXY_PREFIX="${KFQ_GIT_PROXY_PREFIX:-}"

log() { printf '\n[build] %s\n' "$*"; }
fail() { printf '\n[build][ERROR] %s\n' "$*" >&2; exit 1; }

require_docker() {
  command -v docker >/dev/null 2>&1 || fail "未找到 docker 命令"
  docker info >/dev/null 2>&1 || fail "Docker 守护进程不可用"
}

mvn_in_docker() {
  # 在 maven 容器内执行 mvn，参数：<工作目录> <mvn 参数...>
  local workdir="$1"; shift
  docker run --rm -u "$(id -u):$(id -g)" -e HOME=/tmp \
    -v "${PROJECT_ROOT}:/workspace" \
    -v "${M2_DIR}:/m2" \
    -v "${MAVEN_SETTINGS}:/tmp/settings.xml:ro" \
    -w "${workdir}" \
    "${MAVEN_IMAGE}" \
    mvn -B -s /tmp/settings.xml -Dmaven.repo.local=/m2 "$@"
}

build_backend() {
  log "编译后端（maven 容器，首次约 4 分钟）"
  mkdir -p "${BUILD_DIR}"
  mvn_in_docker /workspace/kaifangqian-parent -DskipTests install
  local jar="${PROJECT_ROOT}/kaifangqian-parent/kaifangqian-system/target/kaifangqian.jar"
  [ -f "${jar}" ] || fail "后端产物不存在：${jar}"
  cp -f "${jar}" "${BUILD_DIR}/kaifangqian.jar"
  log "后端产物：${BUILD_DIR}/kaifangqian.jar ($(du -h "${BUILD_DIR}/kaifangqian.jar" | cut -f1))"
}

build_powerjob() {
  log "编译 PowerJob Server ${POWERJOB_VERSION}"
  local src="${CACHE_DIR}/powerjob-${POWERJOB_VERSION}"
  if [ ! -d "${src}" ]; then
    log "本地无 PowerJob 源码，克隆到 ${src}"
    mkdir -p "${CACHE_DIR}"
    local url="https://github.com/PowerJob/PowerJob.git"
    [ -n "${GIT_PROXY_PREFIX}" ] && url="${GIT_PROXY_PREFIX}${url}"
    git clone --depth 1 --branch "v${POWERJOB_VERSION}" "${url}" "${src}" \
      || fail "PowerJob 源码克隆失败，请检查网络或设置 KFQ_GIT_PROXY_PREFIX"
  fi
  mvn_in_docker "${src}" -DskipTests -pl powerjob-server/powerjob-server-starter -am package
  local jar="${src}/powerjob-server/powerjob-server-starter/target/powerjob-server-starter-${POWERJOB_VERSION}.jar"
  [ -f "${jar}" ] || fail "PowerJob 产物不存在：${jar}"
  mkdir -p "${BUILD_DIR}"
  cp -f "${jar}" "${BUILD_DIR}/powerjob-server.jar"
  log "PowerJob 产物：${BUILD_DIR}/powerjob-server.jar ($(du -h "${BUILD_DIR}/powerjob-server.jar" | cut -f1))"
}

build_frontend() {
  log "构建 5 个前端应用（node 容器，内网已有 node_modules 时约数分钟）"
  local web_dir="${PROJECT_ROOT}/kaifangqian-web"
  docker run --rm \
    -v "${web_dir}:/work" \
    -w /work \
    "${NODE_IMAGE}" \
    bash -c '
      set -e
      # 注意：部分子应用 package.json 声明了 pnpm@9（要求 Node 18），
      # corepack 会自动切换版本导致 node16 构建失败；这里改为 npm 直装固定版本覆盖 shim。
      npm install -g pnpm@'"${PNPM_VERSION}"' >/dev/null 2>&1
      echo "=== node $(node -v) / pnpm $(pnpm -v) ==="
      for app in opensign-web opensign-tenant opensign-manage opensign-message opensign-mobile; do
        echo "=== build ${app} ==="
        cd "/work/${app}"
        pnpm install --no-frozen-lockfile
        pnpm build
      done
    '

  log "组装 nginx 站点目录"
  local root_dir="${PROJECT_ROOT}"
  local src="${web_dir}"
  local out="${BUILD_DIR}/webroot"
  mkdir -p "${out}"
  [ -d "${src}/opensign-web/dist/opensign-web" ] || fail "缺少 opensign-web 产物"
  cp -r "${src}/opensign-web/dist/opensign-web/." "${out}/"
  cp -r "${src}/opensign-tenant/dist/tenant" "${out}/tenant"
  cp -r "${src}/opensign-manage/dist/manage" "${out}/manage"
  cp -r "${src}/opensign-message/dist/message" "${out}/message"
  cp -r "${src}/opensign-mobile/dist/mobile" "${out}/mobile"
  cp -r "${src}/handwriting" "${out}/handwriting"
  log "站点产物：${out}"
}

main() {
  require_docker
  local target="${1:-all}"
  case "${target}" in
    all)      build_backend; build_powerjob; build_frontend ;;
    backend)  build_backend ;;
    powerjob) build_powerjob ;;
    frontend) build_frontend ;;
    *)        fail "未知参数：${target}（可选：all|backend|powerjob|frontend）" ;;
  esac
  log "完成"
}

main "$@"
