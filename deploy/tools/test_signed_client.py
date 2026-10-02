#!/usr/bin/env python3
"""signed_client 与服务端签名规范化的一致性验证（最小用例）。

服务端实现：com.kaifangqian.modules.api.util.ApiSignature#getSignCheckContent
规则：参数名升序；空白参数名跳过；空值参与（拼成 k=）；键与值均 RFC3986 编码。

运行：python3 deploy/tools/test_signed_client.py
"""
from __future__ import annotations

import sys
import unittest
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))

import signed_client as sc


class GetSignParamsConsistencyTest(unittest.TestCase):
    def test_skips_blank_key_names_like_server(self):
        params = {"b": "2", "a": "1", "": "should-be-skipped", "   ": "also-skipped", "c": ""}
        self.assertEqual("a=1&b=2&c=", sc._sign_get_params(params))

    def test_rfc3986_encoding_and_key_sorting(self):
        params = {"z": "a b/c=d", "a": "~-_."}
        self.assertEqual("a=~-_.&z=a%20b%2Fc%3Dd", sc._sign_get_params(params))

    def test_empty_params(self):
        self.assertEqual("", sc._sign_get_params({}))


if __name__ == "__main__":
    unittest.main()
