/**
 * @description RSA2加密
 */
package com.kaifangqian.modules.api.util.asymmetric;


import com.kaifangqian.common.constant.ApiConstants;

/**
 * @author : zhenghuihan
 * create at:  2024/3/20  14:21
 * @description:
 */
public class RSA2Encryptor extends RSAEncryptor {
    /**
     * RSA2最大加密明文大小(2048/8-11=244)
     */
    private static final int MAX_ENCRYPT_BLOCK_SIZE = 244;
    /**
     * RSA2最大解密密文大小(2048/8=256)
     */
    private static final int MAX_DECRYPT_BLOCK_SIZE = 256;

    @Override
    protected String getAsymmetricType() {
        return ApiConstants.SIGN_TYPE_RSA2;
    }

    @Override
    protected String getSignAlgorithm() {
        return ApiConstants.SIGN_SHA256RSA_ALGORITHMS;
    }

    @Override
    protected int getMaxDecryptBlockSize() {
        return MAX_DECRYPT_BLOCK_SIZE;
    }

    @Override
    protected int getMaxEncryptBlockSize() {
        return MAX_ENCRYPT_BLOCK_SIZE;
    }
}