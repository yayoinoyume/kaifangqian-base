/**
 * @description 签署人接受通知方式类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignRuSignerExternalTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignRuSignerExternalTypeEnum
 * @author: FengLai_Gong
 */
public enum SignRuSignerExternalTypeEnum {


    PHONE(1,"手机号"),
    EMAIL(2,"邮箱号"),

    ;
    private Integer code  ;

    private String name ;

    SignRuSignerExternalTypeEnum(Integer code, String name){
        this.code = code ;
        this.name = name;
    }


    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }
}