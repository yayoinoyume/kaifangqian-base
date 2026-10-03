/**
 * @description 电子签类型
 */
package com.kaifangqian.modules.api.util.asymmetric;

import com.kaifangqian.modules.api.exception.RequestParamsException;
import com.kaifangqian.common.constant.ApiCode;
import com.kaifangqian.utils.MyStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author : zhenghuihan
 * create at:  2024/3/20  14:23
 * @description:
 */
public abstract class BaseAsymmetricEncryptor implements IAsymmetricEncryptor {

    private static String DEFAULT_CHARSET = "UTF-8";

    public String decrypt(String cipherTextBase64, String charset, String privateKey) throws RequestParamsException {
        try {
            if (MyStringUtils.isEmpty(cipherTextBase64)) {
                throw new RequestParamsException(ApiCode.PARAM_NULL);
            }
            if (MyStringUtils.isEmpty(privateKey)) {
                throw new RequestParamsException(ApiCode.PARAM_NULL);
            }
            if (MyStringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doDecrypt(cipherTextBase64, charset, privateKey);

        } catch (Exception e) {
            throw new RequestParamsException(ApiCode.UNKNOWN);
        }
    }

    public String encrypt(String plainText, String charset, String publicKey) throws RequestParamsException {
        try {
            if (MyStringUtils.isEmpty(plainText)) {
                throw new RequestParamsException(ApiCode.PARAM_NULL);
            }
            if (MyStringUtils.isEmpty(publicKey)) {
                throw new RequestParamsException(ApiCode.PARAM_NULL);
            }
            if (MyStringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doEncrypt(plainText, charset, publicKey);
        } catch (Exception e) {
            throw new RequestParamsException(ApiCode.UNKNOWN);
        }

    }

    public String sign(String content, String charset, String privateKey) throws RequestParamsException {
        try {
            if (MyStringUtils.isEmpty(content)) {
                throw new RequestParamsException(ApiCode.PARAM_NULL);
            }
            if (MyStringUtils.isEmpty(privateKey)) {
                throw new RequestParamsException(ApiCode.PARAM_NULL);
            }
            if (MyStringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doSign(content, charset, privateKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            String errorMessage = String.format(ApiCode.SIGN_CHARSET_ERROR.getTemplate(),
                    getAsymmetricType(), charset);

            throw new RequestParamsException(ApiCode.SIGN_CHARSET_ERROR, errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RequestParamsException(ApiCode.UNKNOWN);
        }

    }

    public boolean verify(String content, String charset, String publicKey, String sign) throws RequestParamsException {
        if (MyStringUtils.isEmpty(content)) {
            throw new RequestParamsException(ApiCode.PARAM_NULL);
        }
        if (MyStringUtils.isEmpty(publicKey)) {
            throw new RequestParamsException(ApiCode.PARAM_NULL);
        }
        if (MyStringUtils.isEmpty(sign)) {
            throw new RequestParamsException(ApiCode.PARAM_NULL);
        }
        if (MyStringUtils.isEmpty(charset)) {
            charset = DEFAULT_CHARSET;
        }
        try {
            return doVerify(content, charset, publicKey, sign);
        } catch (Exception e) {
            throw new RequestParamsException(ApiCode.DATA_CHECK_ERROR);
        }
    }

    protected abstract String doDecrypt(String cipherTextBase64, String charset, String privateKey) throws Exception;

    protected abstract String doEncrypt(String plainText, String charset, String publicKey) throws Exception;

    protected abstract String doSign(String content, String charset, String privateKey) throws Exception;

    protected abstract boolean doVerify(String content, String charset, String publicKey, String sign) throws Exception;

    protected abstract String getAsymmetricType();

}