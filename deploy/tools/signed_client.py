#!/usr/bin/env python3
"""开放签 OpenAPI 签名客户端（RSA2 / SHA256withRSA）。

== 为什么要签名 ==
后端 `ApiSignThreadLocalAop` 自 2026-09-20 起强制验签，未签名或签名不匹配的请求
会被拒绝（返回码 26000）。验签公钥存在数据库 `api_developer_manage.public_key`，
私钥由调用方自己保管。

== 两种签名规则（务必区分） ==
* POST / PUT：对 **原始请求体字符串 + 时间戳后缀** 签名。
  也就是你实际发出去的那串 JSON 文本（逐字节一致），再追加
  "&timestamp=<毫秒>&nonce=<随机串>" 后签名。

* GET / DELETE：对 **规范化查询参数 + 时间戳后缀** 签名。
  参数按参数名升序，格式 `k=v`，空值参数也参与（拼成 k=），
  参数名与值均按 RFC 3986 百分号编码（未保留字符保留，其余大写 %XX），
  最后再追加 "&timestamp=<毫秒>&nonce=<随机串>"。

签名结果用 Base64 编码，放在请求头 `sign` 里；`timestamp` 与 `nonce` 同时放在同名请求头，
服务端会校验 ±5 分钟时间窗口并对 nonce 做一次性消费（防重放）。

== 凭据从哪来（代码里不含任何凭据） ==
* token：`deploy/compose/.env` 的 `KAIFANGQIAN_API_TOKEN`（可用环境变量 KFQ_TOKEN 覆盖）
* 私钥：`deploy/compose/.secrets/api-client-private.pem`
  （可用环境变量 KFQ_PRIVATE_KEY 指定其他路径）
* 服务地址：`deploy/compose/.env` 的 `KAIFANGQIAN_APP_ADDRESS`
  （可用环境变量 KFQ_APP_ADDRESS 覆盖）

== 命令行用法 ==
    python3 deploy/tools/signed_client.py get /contract/tasks '{"contractId":"xxx"}'
    python3 deploy/tools/signed_client.py post /contract/draft @payload.json
    python3 deploy/tools/signed_client.py upload ./贫困生资助审批表.pdf

== 作为库调用 ==
    from signed_client import get, post, upload
    print(get("/contract/tasks", {"contractId": "xxx"}))
"""
from __future__ import annotations

import base64
import json
import os
import subprocess
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
import uuid
from pathlib import Path

TOOLS_DIR = Path(__file__).resolve().parent
COMPOSE_DIR = TOOLS_DIR.parent / "compose"
DEFAULT_ENV_FILE = COMPOSE_DIR / ".env"
DEFAULT_PRIVATE_KEY = COMPOSE_DIR / ".secrets" / "api-client-private.pem"


def _load_env_file(path: Path) -> dict:
    """极简 .env 解析：KEY=VALUE，支持单/双引号，忽略注释与空行。"""
    values = {}
    if not path.is_file():
        return values
    for raw in path.read_text(encoding="utf-8").splitlines():
        line = raw.strip()
        if not line or line.startswith("#") or "=" not in line:
            continue
        key, value = line.split("=", 1)
        value = value.strip()
        if len(value) >= 2 and value[0] == value[-1] and value[0] in "\"'":
            value = value[1:-1]
        values[key.strip()] = value
    return values


_ENV_FILE = Path(os.environ.get("KFQ_ENV_FILE", DEFAULT_ENV_FILE))
_ENV = _load_env_file(_ENV_FILE)

APP_ADDRESS = (
    os.environ.get("KFQ_APP_ADDRESS")
    or _ENV.get("KAIFANGQIAN_APP_ADDRESS")
    or "http://localhost:8806"
).rstrip("/")
BASE = os.environ.get("KFQ_BASE") or f"{APP_ADDRESS}/resrun-paas/kaifangqian/openAPI/V2"

TOKEN = os.environ.get("KFQ_TOKEN") or _ENV.get("KAIFANGQIAN_API_TOKEN", "")
PRIVATE_KEY = Path(os.environ.get("KFQ_PRIVATE_KEY", DEFAULT_PRIVATE_KEY))
OPERATOR_ACCOUNT = os.environ.get("KFQ_OPERATOR_ACCOUNT") or "admin"


def _require_token() -> str:
    if not TOKEN:
        raise SystemExit(
            f"未找到 OpenAPI token。请检查 {_ENV_FILE} 的 KAIFANGQIAN_API_TOKEN，"
            "或设置环境变量 KFQ_TOKEN。"
        )
    return TOKEN


def sign_content(content: str, private_key: Path | None = None) -> str:
    """用私钥对内容做 SHA256withRSA 签名，返回 Base64 字符串。"""
    key = private_key or PRIVATE_KEY
    if not key.is_file():
        raise SystemExit(f"未找到签名私钥：{key}")
    proc = subprocess.run(
        ["openssl", "dgst", "-sha256", "-sign", str(key)],
        input=content.encode("utf-8"),
        capture_output=True,
    )
    if proc.returncode != 0:
        raise SystemExit(f"签名失败：{proc.stderr.decode('utf-8', 'replace').strip()}")
    return base64.b64encode(proc.stdout).decode()


def _common(payload: dict | None) -> dict:
    data = dict(payload or {})
    data["appAuthToken"] = _require_token()
    data.setdefault("operatorAccount", OPERATOR_ACCOUNT)
    data.setdefault("uniqueCode", uuid.uuid4().hex)
    return data


def _rfc3986(value) -> str:
    """RFC 3986 百分号编码，与服务端 ApiSignature.encodeRfc3986 保持一致。"""
    return urllib.parse.quote(str(value), safe="-_.~")


def _sign_get_params(params: dict) -> str:
    """GET/DELETE 的签名内容：按 key 升序、RFC3986 编码，空值也参与（拼成 k=）。"""
    pairs = []
    for key in sorted(params.keys()):
        value = params[key]
        if value is None:
            continue
        pairs.append(f"{_rfc3986(key)}={_rfc3986(value)}")
    return "&".join(pairs)


def _time_nonce_suffix(timestamp: str, nonce: str) -> str:
    """把 timestamp/nonce 追加到待签名内容，保证二者不可被篡改。"""
    return f"&timestamp={timestamp}&nonce={nonce}"


def _read_response(req: urllib.request.Request, raw: bool):
    try:
        with urllib.request.urlopen(req, timeout=180) as resp:
            body = resp.read()
    except urllib.error.HTTPError as exc:
        body = exc.read()
    if raw:
        return body
    try:
        return json.loads(body.decode("utf-8"))
    except Exception:
        return {"_raw": body[:2000].decode("utf-8", "replace")}


def post(path: str, payload: dict | None = None, raw: bool = False):
    """POST：对原始请求体 + timestamp/nonce 后缀签名。"""
    data = _common(payload)
    body = json.dumps(data, ensure_ascii=False).encode("utf-8")
    timestamp = str(int(time.time() * 1000))
    nonce = uuid.uuid4().hex
    sign = sign_content(body.decode("utf-8") + _time_nonce_suffix(timestamp, nonce))
    req = urllib.request.Request(
        BASE + path,
        data=body,
        headers={
            "Content-Type": "application/json",
            "sign": sign,
            "timestamp": timestamp,
            "nonce": nonce,
        },
        method="POST",
    )
    return _read_response(req, raw)


def get(path: str, params: dict | None = None, raw: bool = False):
    """GET：对规范化查询参数 + timestamp/nonce 后缀签名。"""
    query_params = _common(params)
    timestamp = str(int(time.time() * 1000))
    nonce = uuid.uuid4().hex
    sign = sign_content(_sign_get_params(query_params) + _time_nonce_suffix(timestamp, nonce))
    url = BASE + path + "?" + urllib.parse.urlencode(query_params)
    req = urllib.request.Request(
        url,
        headers={"sign": sign, "timestamp": timestamp, "nonce": nonce},
        method="GET",
    )
    return _read_response(req, raw)


def upload(file_path: str | Path, file_name: str | None = None):
    """上传文档：POST /document/file（fileSuffix 必须带点）。"""
    path = Path(file_path)
    if not path.is_file():
        raise SystemExit(f"文件不存在：{path}")
    name = file_name or path.name
    suffix = "." + name.rsplit(".", 1)[-1]
    with open(path, "rb") as handle:
        content_b64 = base64.b64encode(handle.read()).decode()
    return post("/document/file", {"fileName": name, "fileSuffix": suffix, "file": content_b64})


def _cli(argv: list[str]) -> int:
    if len(argv) < 2:
        print(__doc__)
        return 2
    action = argv[1]
    if action == "upload":
        if len(argv) < 3:
            print("用法：signed_client.py upload <文件路径> [文件名]")
            return 2
        result = upload(argv[2], argv[3] if len(argv) > 3 else None)
    elif action in ("get", "post"):
        if len(argv) < 3:
            print(f"用法：signed_client.py {action} <路径> [JSON 载荷 | @文件]")
            return 2
        payload = None
        if len(argv) > 3:
            raw_arg = argv[3]
            if raw_arg.startswith("@"):
                payload = json.loads(Path(raw_arg[1:]).read_text(encoding="utf-8"))
            else:
                payload = json.loads(raw_arg)
        result = get(argv[2], payload) if action == "get" else post(argv[2], payload)
    else:
        print(f"未知命令：{action}\n")
        print(__doc__)
        return 2

    print(json.dumps(result, ensure_ascii=False, indent=2))
    if isinstance(result, dict) and result.get("code") not in (10000, None):
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(_cli(sys.argv))
