/**
 * @description 资助审批电子签章系统业务静态变量数据
 */

package com.kaifangqian.common.constant;

/**
 * @author : zhenghuihan
 * create at:  2024/3/20  14:34
 */
public class ApiConstants {

    public static final String SIGN_TYPE = "signType";

    public static final String SIGN_TYPE_RSA = "RSA";

    /**
     * sha256WithRsa 算法请求类型
     */
    public static final String SIGN_TYPE_RSA2 = "RSA2";

    public static final String SHA_TYPE = "SHA1";

    public static final String SHA_TYPE256 = "SHA256";

    public static final String SIGN_TYPE_SM2 = "SM2";

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    public static final String ENCRYPT_TYPE_AES = "AES";

    public static final String APP_ID = "appId";

    public static final String TIMESTAMP = "timestamp";

    public static final String NONCE = "nonce";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date默认时区
     **/
    public static final String DATE_TIMEZONE = "GMT+8";

    public static final String SIGN = "sign";

    public static final String APP_AUTH_TOKEN = "appAuthToken";

    public static final String OPERATOR_ACCOUNT = "operatorAccount";

    public static final String UNIQUE_CODE = "uniqueCode";

    public static final String YD_AUTH_TOKEN = "appId";

    public static final String YD_NONCE = "nonce";

    public static final String YD_BIZ_CONTENT_ORDER_NO = "orderNo";

    public static final String YD_BIZ_CONTENT_UNOIN_ID = "unionId";

    public static final String REQ_PARA = "reqPara";

    public static final String FROM_TYPE = "fromType";

    public static final String FROM_API = "api";

    public static final String FROM_WEB = "web";

    /**
     * UTF-8字符集
     **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * GBK字符集
     **/
    public static final String CHARSET_GBK = "GBK";

    public static final String EXTEND_TYPE_USER = "USER";

    public static final String EXTEND_TYPE_TENANT = "TENANT";

    public static final String API_QUEUE_KEY = "api_message_queue";

//    public static final String API_PROCESSING_KEY = "api_processing_queue";

}