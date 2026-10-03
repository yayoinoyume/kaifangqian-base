/**
 * @description 电子签名类型
 */
package com.kaifangqian.modules.api.util.asymmetric;

import com.kaifangqian.common.constant.ApiConstants;
import com.kaifangqian.exception.PaasException;

/**
 * @author : zhenghuihan
 * create at:  2024/3/20  14:19
 * @description:
 */
public class AsymmetricManager {

    public static IAsymmetricEncryptor getByName(String type) throws PaasException {
        if (ApiConstants.SIGN_TYPE_RSA.equals(type)) {
            return new RSAEncryptor();
        }
        if (ApiConstants.SIGN_TYPE_RSA2.equals(type)) {
            return new RSA2Encryptor();
        }
        if (ApiConstants.SIGN_TYPE_SM2.equals(type)) {
            return new SM2Encryptor();
        }
        return new RSA2Encryptor();
    }

}