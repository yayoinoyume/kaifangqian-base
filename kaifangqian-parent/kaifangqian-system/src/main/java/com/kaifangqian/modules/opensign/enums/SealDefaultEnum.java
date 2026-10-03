/**
 * @description 签章是否为默认枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 签章是否为默认枚举
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: SealDefault
 * @author: FengLai_Gong
 */
public enum SealDefaultEnum {

    IS(1,"默认"),
    NOT(2,"非默认")

    ;

    private Integer code ;
    private String name ;

    SealDefaultEnum(Integer code, String name){
        this.code = code ;
        this.name = name ;
    }

    public String getName(){
        return this.name ;
    }

    public Integer getCode(){
        return this.code ;
    }
}