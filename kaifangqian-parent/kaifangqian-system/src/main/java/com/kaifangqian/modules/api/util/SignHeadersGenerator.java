/**
 * @description API请求头签名
 */
package com.kaifangqian.modules.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaifangqian.common.util.oConvertUtils;

import java.util.HashMap;
import java.util.Map;

public class SignHeadersGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {

    }

    /**
     * 完成请求信息签名，返回签名头信息
     */
    public static Map<String,String> generateSignHeaders(String appId, String jsonParams, String uri, String privateKey) throws Exception {
        // 1. 计算biz_content
        String canonicalJson = null;
        String bizContent = null;
        if(jsonParams != null){
            canonicalJson = SignGenerator.canonicalizeJson(jsonParams);
            bizContent = SignGenerator.computeBizContent(canonicalJson);
        }

        // 2. 组装签名字符串（含URL编码）
        String timestamp = System.currentTimeMillis()+"";
        String nonce = oConvertUtils.randomGen(16);

        String signString = SignGenerator.buildSignString(appId, timestamp, nonce, uri, bizContent);

        Map<String,String> headers = new HashMap<>();
        headers.put("appId",appId);
        headers.put("timestamp",timestamp);
        headers.put("nonce", nonce);

        // 计算签名值
        String signVal = ApiSignature.sign(signString,null, privateKey,"RSA2");
        headers.put("sign", signVal);

        return headers;
    }


}
