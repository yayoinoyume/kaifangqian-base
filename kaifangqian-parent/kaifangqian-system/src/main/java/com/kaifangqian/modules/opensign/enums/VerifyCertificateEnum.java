/**
 * @description 证书状态类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: VerifyCertificateEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: VerifyCertificateEnum
 * @author: FengLai_Gong
 */
public enum VerifyCertificateEnum {

    NO_USE_CERTIFICATE(1,"不校验证书"),
    NO_HAVE_CERTIFICATE(2,"无证书"),
    UN_ENABLE_CERTIFICATE(3,"证书无效"),
    ENABLE_CERTIFICATE(4,"证书有效"),


    ;


    VerifyCertificateEnum(Integer code ,String name){
        this.code = code;
        this.name = name;
    }

    private Integer code ;
    private String name ;

    public String getName(){
        return this.name;
    }

    public Integer getCode(){
        return this.code;
    }


}