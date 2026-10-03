/**
 * @description 签署方角色类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignerTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignerTypeEnum
 * @author: FengLai_Gong
 */
public enum SignerTypeEnum {


    SENDER(1,"发起方","SENDER"),
    RECEIVER_PERSONAL(2,"个人接收方","RECEIVER_PERSONAL"),
    RECEIVER_ENT(3,"企业接收方","RECEIVER_ENT"),


    ;
    private Integer code  ;

    private String name ;

    private String apiName ;
    public String getApiName(){
        return this.apiName;
    }

    SignerTypeEnum(Integer code, String name){
        this.code = code ;
        this.name = name;
    }

    SignerTypeEnum(Integer code, String name,String apiName){
        this.code = code ;
        this.name = name;
        this.apiName = apiName;
    }


    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }

}