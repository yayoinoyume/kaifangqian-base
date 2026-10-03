/**
 * @description API签名验签
 */
package com.kaifangqian.modules.api.util;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import com.kaifangqian.modules.api.util.asymmetric.AsymmetricManager;
import com.kaifangqian.common.util.oConvertUtils;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.api.vo.request.TestVO;
import com.kaifangqian.utils.HttpClient4Utils;
import com.kaifangqian.utils.MyStringUtils;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author : zhenghuihan
 * create at:  2024/3/20  14:11
 * @description:
 */
public class ApiSignature {

    /**
     * @param
     * @return 签名后的数据
     * @description 处理参数
     */
    public static String sign(String content, String charset, String privateKey, String signType) throws PaasException {

        return AsymmetricManager.getByName(signType).sign(content, charset, privateKey);
    }

    /**
     * @param
     * @return true：验签通过；false：验签不通过
     * @throws com.kaifangqian.exception.PaasException
     * @create by zhenghuihan
     * @createTime 2024/3/20 14:13
     * @description 处理参数
     */

    public static boolean check(Map<String, String> params, String sign, String publicKey, String charset, String signType) throws PaasException {
        String content = getSignCheckContent(params);

        return check(content, sign, publicKey, charset, signType);
    }


    public static boolean check(String content, String sign, String publicKey, String charset, String signType) throws PaasException {

        return AsymmetricManager.getByName(signType).verify(content, charset, publicKey, sign);
    }


    /**
     * 生成 GET/DELETE 的待签名内容。
     *
     * 规范化规则（客户端必须与服务端完全一致）：
     *   1. 参与签名的参数集合与业务可见的参数集合一致，空值参数也参与（拼成 k=）；
     *   2. 参数名按升序排列；
     *   3. 参数名与参数值都按 RFC 3986 百分号编码，消除 & / = 等分隔符带来的歧义；
     *   4. 重复参数名属于非法请求，由调用方在验签前拒绝。
     */
    public static String getSignCheckContent(Map<String, String> params) {
        if (params == null) {
            return "";
        }
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (MyStringUtils.isBlank(key)) {
                continue;
            }
            String value = params.get(key);
            if (value == null) {
                value = "";
            }
            if (content.length() > 0) {
                content.append('&');
            }
            content.append(encodeRfc3986(key)).append('=').append(encodeRfc3986(value));
        }

        return content.toString();
    }

    /**
     * RFC 3986 百分号编码：仅保留未保留字符（A-Za-z0-9-_.~），其余按 UTF-8 字节大写十六进制编码。
     * 客户端（Python signed_client.py 的 quote(safe="-_.~")）必须使用同一规则。
     */
    private static String encodeRfc3986(String value) {
        if (value == null) {
            return "";
        }
        try {
            byte[] bytes = value.getBytes("UTF-8");
            StringBuilder encoded = new StringBuilder(bytes.length);
            for (byte b : bytes) {
                int c = b & 0xFF;
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
                        || c == '-' || c == '_' || c == '.' || c == '~') {
                    encoded.append((char) c);
                } else {
                    encoded.append('%');
                    encoded.append(Character.toUpperCase(Character.forDigit((c >> 4) & 0xF, 16)));
                    encoded.append(Character.toUpperCase(Character.forDigit(c & 0xF, 16)));
                }
            }
            return encoded.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 不受支持", e);
        }
    }

    //生成签名值
//    public static void main(String[] args) throws Exception {
//        Map<String, String> params = new HashMap<>();
//        params.put("name", "测试名称");
//        params.put("appAuthToken", "2244d00d-5316-47cc-90f0-4f78d36cd833");
//        params.put("uniqueCode", "dasdadada");
//
//        StringEntity postEntity = new StringEntity(JSONObject.toJSONString(params), "UTF-8");
//        String content0 = EntityUtils.toString(postEntity);
//        //String content = getSignCheckContent(params);
//        String content1 = "{\n" +
//                "    \"uniqueCode\":\"dasdadada\",\n" +
//                "    \"appAuthToken\":\"2244d00d-5316-47cc-90f0-4f78d36cd833\",\n" +
//                "    \"name\":\"测试名称\"\n" +
//                "}";
//        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCM19A45gipMuzcG+otPFl+rTZLmoJS0t5QIJoAwwBzCp0eqMFlPqeTZkxwsvT3ZhirHk7KxAHBEeQJNtKhVce8byicKot8vA3lDl0lQ4qY3dEqKvp7jJsPPSnNwwbgNjbV9QXwezxKzD0cQntLWvI2GaHEtGRCCEzB9BBmK5HCwRl6FG+3ubBRO8Yv5LTJbcowlodqF+7eHXOXXqJ4DMA87VRAVMeFWqwUi0gToxBYVYys9aD+5GSi1mD28XyEnVocjSw7vdLLFsBComAXZBgfrATYwdiXNA9l32mECm9DGZoyTTBjoHcQp1WfM40Q9kZldYvfjVNtRjN+RPoRfThxAgMBAAECggEAfxmK2K4OhtJkGcY/MA9UHBMn+lY24ZNV+C1TjPhtAWREohRcYoeGJmic9t8oXdKO1G2HYUg85QTGKuKEdf+5Pf16QmPKeQgj6d9qg2ROQOF8Dne2j6Q1kiz5+qvTGqcSGUcC0yADKuThCQ2dwkUSa2v6Jk88YrKmwikEW49Z/Mt68Zft493i4YQaZIfQ57RepRuKhyQ+bPSTZE+s7GeCe5PHzyYAO/7FIuoa6VzMfoeLmxQy4W8Lib1ifuA4HTDpXUKRQ6Rzxh8NN11fc8WiOr6VIV7uSwGSTRDZpr/1QBzkfkNYf9J+A+ncejc1Hn+IZcH5MaXXNlCtrfH9229wAQKBgQDBfSY20kdLO/giVGyGPYXnPCUcJn5t4bNIUMp1aWDvQuRy3PkNrU0P01yRHPLWeruD9aD6UHfcy/niVUpU9YYsJuglvm2rXZ0yyHC+Xpw0DwoOVES14fCxRruMOt5K/8NThLoj3p7+trGsGDFD5qPlHIFMZUhs2VTyxs4hMS5+8QKBgQC6WH5FPgKgyQRAwaK762Wn47d3Jbh0eKPkrn6P/Zsn+eUhDqqajp55UNi09R0xpyXuxJyOsauyjxBQshKKvNJckZyd9CjPVIexTrByTT7zz4cMaV/Zlxf485/XDe7xxAQXYQ4C8JD4rtWsJDlJlQbZ8UXoE6171+1kST46+zVRgQKBgQCOIe7GaqVwgLcAEOA/pEYO3MGt8iEBesCGKMLwiN5qI8tJDUXuZBWtwGfJOWixYSsJ/o+oESBbk4MWXeziiBFtsY7q2v4Y2gW13kPjtAAuxbVvXTu0GCsFLp5qnnvYwBSt71wFKW3GUlIlxwe5h11x2gSpJ+WR//xE8wFMpKIxIQKBgFDTVWGfNfCbgBa+ZmFwBtW9dbReThVmxl/IN+korQW35GRkQidruN0R7gz/TDxfLZrU+LsD4V8/omn98wDuSagRGIeCgbj8Bycm5G2Ph8CkwQTnJ8XvPVyj/y5+Qqfmx4eEd1lbEuZqnw9dXuPFmgUqG5JABr1yuOsIwc8/aq8BAoGAJHNqUbV08txEDSVH5HcrkR+bJKqwT0UfvMt/qSyXWC1+EWSM//tXpMvdQHDdu0VOJEc0wfbsHLREnsBnsFGUNX74kty+i71M/eCjItsP8oyz0r+GgdtaSnjKwg/OYYrpn7Px1viDy2dS+xD4z2+UWgz0c1JTmV3E69vhecLp2NI=";
//        String sign0 = AsymmetricManager.getByName("RSA2").sign(content0, null, privateKey);
//
//        String sign1 = AsymmetricManager.getByName("RSA2").sign(content1, null, privateKey);
//
//
//        System.out.println(sign0);
//        System.out.println(sign1);
//    }

    //post测试签名验签
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient4Utils.createHttpClient(100, 20, 10000, 10000, 10000);
        Map<String, String> params = new HashMap<>();
        params.put("name", "测试名称");
        params.put("appAuthToken", "2244d00d-5316-47cc-90f0-4f78d36cd833");
        params.put("uniqueCode", "dasdadada");

        TestVO vo = new TestVO();
        vo.setName("测试名称");
        vo.setUniqueCode("uuid");
        vo.setAppAuthToken("2244d00d-5316-47cc-90f0-4f78d36cd833");

        JSONObject params1 = (JSONObject)JSONObject.toJSON(vo);

        // 将参数按ASCII顺序排列并拼接
        Map<String, Object> sortedParams = new TreeMap<>();
        sortedParams.put("appId", "123");
        sortedParams.put("timestamp", "timestamp");
        sortedParams.put("nonce","nonce");
        sortedParams.put("params", params1);

        StringBuilder signBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedParams.entrySet()) {
            signBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signBuilder.deleteCharAt(signBuilder.length() - 1);



        String encoding = Consts.UTF_8.name();
        HttpPost httpPost = new HttpPost("http://localhost:8899/resrun-paas/api/test/post");
        httpPost.setHeader("Content-Type", "application/json");
        String requestBodyStr = "";
        if (CollUtil.isNotEmpty(params)) {
            StringEntity postEntity = new StringEntity(JSONObject.toJSONString(vo), encoding);
            httpPost.setEntity(postEntity);
            requestBodyStr = EntityUtils.toString(postEntity);
        }
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCM19A45gipMuzcG+otPFl+rTZLmoJS0t5QIJoAwwBzCp0eqMFlPqeTZkxwsvT3ZhirHk7KxAHBEeQJNtKhVce8byicKot8vA3lDl0lQ4qY3dEqKvp7jJsPPSnNwwbgNjbV9QXwezxKzD0cQntLWvI2GaHEtGRCCEzB9BBmK5HCwRl6FG+3ubBRO8Yv5LTJbcowlodqF+7eHXOXXqJ4DMA87VRAVMeFWqwUi0gToxBYVYys9aD+5GSi1mD28XyEnVocjSw7vdLLFsBComAXZBgfrATYwdiXNA9l32mECm9DGZoyTTBjoHcQp1WfM40Q9kZldYvfjVNtRjN+RPoRfThxAgMBAAECggEAfxmK2K4OhtJkGcY/MA9UHBMn+lY24ZNV+C1TjPhtAWREohRcYoeGJmic9t8oXdKO1G2HYUg85QTGKuKEdf+5Pf16QmPKeQgj6d9qg2ROQOF8Dne2j6Q1kiz5+qvTGqcSGUcC0yADKuThCQ2dwkUSa2v6Jk88YrKmwikEW49Z/Mt68Zft493i4YQaZIfQ57RepRuKhyQ+bPSTZE+s7GeCe5PHzyYAO/7FIuoa6VzMfoeLmxQy4W8Lib1ifuA4HTDpXUKRQ6Rzxh8NN11fc8WiOr6VIV7uSwGSTRDZpr/1QBzkfkNYf9J+A+ncejc1Hn+IZcH5MaXXNlCtrfH9229wAQKBgQDBfSY20kdLO/giVGyGPYXnPCUcJn5t4bNIUMp1aWDvQuRy3PkNrU0P01yRHPLWeruD9aD6UHfcy/niVUpU9YYsJuglvm2rXZ0yyHC+Xpw0DwoOVES14fCxRruMOt5K/8NThLoj3p7+trGsGDFD5qPlHIFMZUhs2VTyxs4hMS5+8QKBgQC6WH5FPgKgyQRAwaK762Wn47d3Jbh0eKPkrn6P/Zsn+eUhDqqajp55UNi09R0xpyXuxJyOsauyjxBQshKKvNJckZyd9CjPVIexTrByTT7zz4cMaV/Zlxf485/XDe7xxAQXYQ4C8JD4rtWsJDlJlQbZ8UXoE6171+1kST46+zVRgQKBgQCOIe7GaqVwgLcAEOA/pEYO3MGt8iEBesCGKMLwiN5qI8tJDUXuZBWtwGfJOWixYSsJ/o+oESBbk4MWXeziiBFtsY7q2v4Y2gW13kPjtAAuxbVvXTu0GCsFLp5qnnvYwBSt71wFKW3GUlIlxwe5h11x2gSpJ+WR//xE8wFMpKIxIQKBgFDTVWGfNfCbgBa+ZmFwBtW9dbReThVmxl/IN+korQW35GRkQidruN0R7gz/TDxfLZrU+LsD4V8/omn98wDuSagRGIeCgbj8Bycm5G2Ph8CkwQTnJ8XvPVyj/y5+Qqfmx4eEd1lbEuZqnw9dXuPFmgUqG5JABr1yuOsIwc8/aq8BAoGAJHNqUbV08txEDSVH5HcrkR+bJKqwT0UfvMt/qSyXWC1+EWSM//tXpMvdQHDdu0VOJEc0wfbsHLREnsBnsFGUNX74kty+i71M/eCjItsP8oyz0r+GgdtaSnjKwg/OYYrpn7Px1viDy2dS+xD4z2+UWgz0c1JTmV3E69vhecLp2NI=";

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjNfQOOYIqTLs3BvqLTxZfq02S5qCUtLeUCCaAMMAcwqdHqjBZT6nk2ZMcLL092YYqx5OysQBwRHkCTbSoVXHvG8onCqLfLwN5Q5dJUOKmN3RKir6e4ybDz0pzcMG4DY21fUF8Hs8Ssw9HEJ7S1ryNhmhxLRkQghMwfQQZiuRwsEZehRvt7mwUTvGL+S0yW3KMJaHahfu3h1zl16ieAzAPO1UQFTHhVqsFItIE6MQWFWMrPWg/uRkotZg9vF8hJ1aHI0sO73SyxbAQqJgF2QYH6wE2MHYlzQPZd9phApvQxmaMk0wY6B3EKdVnzONEPZGZXWL341TbUYzfkT6EX04cQIDAQAB";
        String sign = AsymmetricManager.getByName("RSA2").sign(requestBodyStr, null, privateKey);
        // 计算签名值（这里使用的是MD5加密，根据实际需要替换为合适的加密方式）

        String content = "appId=MJASN1GG&biz_content=&nonce=v427x0iEFjjDAfXn&timestamp=1754367778748&uri=%2Fyundun%2Fapi%2Fv1%2Fsign%2Fapp%2Finfo";


        String timestamp = System.currentTimeMillis()+"";
        String nonce = oConvertUtils.randomGen(16);
        String uri = "/yundun/api/v1/sign/app/info";
        String signString = SignGenerator.buildSignString("MJASN1GG", timestamp, nonce, uri, null);
        System.out.println("signString:"+signString);

        String signVal = ApiSignature.sign(signString,null, privateKey,"RSA2");

        System.out.println("signVal:"+signVal);

        String signValTemp = "OsuqDUsc7c4c8Jn3vKuLyyPePliHuOcbKctsXuvdevsSF/X+h0XW3k0i3OFhoOQb7Gv59wlH0+HG0cge7Zyt3S7vQ1XB56RBMVmeATSofQzx1aPo+2wqlljEt/H1Uvyifm1A7qUQ2e8LKnN2hW4ZV8CvWKmDXDEnCG5P46qT1bfCAgFlF7jb0BNqBEWIyFFrkfPnUf5E3VEtxwvsSkym7jq6/Jk0RYjdc21ZAPAYuA2mxlFcR/MytAvcAGhXylio0EmTRfmQ8YUh/tET4eDOGqqLkbTWUfKBuqi3d+DBQQMWWmM6A1THamVWmuo7Wx7asI4Scf/20l9mhRQ9GEhM3g==";

        String signValTemp2 = "iGCQrIOFqcnvU/LBBP0IN/aZX2vMsQSeTZFu0s4f4U//Q09m9LPZtihzAcojMOKKjHVYMFtx3+QEJqbmxBCl3LtOSseAAosIJiglpQmgwPA5AMPhJ7WaHCxCqbF9ygWizCMg1AnHZNdc6A5J/dfbwAcLrTE06BH0wFKhnux0R87rEUATx8SOEW73OHcVGIWJuHaGoq/vWQNlOFdzCiFGktjhGetQP7+a1CC36NaWWroPjAvNAmwHC9G3KIMu5nDSPzHyp6YGoHNzbGwyK/IjD+cOuvRwA8YEHwo6D4y0rKLCsAaYKPqeQDLZK/lzCgRCtSvmC6n8dYTXVJkFLS7YFw==";

        //String signVal = ApiSignature.sign(signBuilder.toString(),null, privateKey,"RSA2");

        boolean isValid = ApiSignature.check(signString, signVal, publicKey, encoding, "RSA2");

        System.out.println(isValid);

        //httpPost.setHeader("sign", signVal);
        //CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(httpPost);

        //String resst = EntityUtils.toString(response.getEntity(), encoding);
        //System.out.println(resst);
    }
}