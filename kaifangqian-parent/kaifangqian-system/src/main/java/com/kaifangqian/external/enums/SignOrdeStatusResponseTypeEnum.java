/**
 * @description 签署状态枚举
 */
package com.kaifangqian.external.enums;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
public enum SignOrdeStatusResponseTypeEnum {
    NO_AUTH(0,"订单未完成意愿验证"),

    VERIFY_SUCCESS(1,"订单意愿验证成功"),

    INVALID(2,"订单失效"),

    SIGN_DONE(3,"订单已被签署"),

    ;

    SignOrdeStatusResponseTypeEnum(Integer code , String name){
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

