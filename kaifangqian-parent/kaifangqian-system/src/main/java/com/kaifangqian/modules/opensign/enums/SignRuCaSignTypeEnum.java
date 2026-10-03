/**
 * @description 电子签类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignRuCaSignTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignRuCaSignTypeEnum
 * @author: FengLai_Gong
 */
public enum SignRuCaSignTypeEnum {

    CA(1,"使用ca证书"),
    SYSTEM_CA(2,"使用防篡改证书"),
    NO_USE_CA(3,"不使用证书"),

    ;
    private Integer code  ;

    private String name ;

    SignRuCaSignTypeEnum(Integer code, String name){
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