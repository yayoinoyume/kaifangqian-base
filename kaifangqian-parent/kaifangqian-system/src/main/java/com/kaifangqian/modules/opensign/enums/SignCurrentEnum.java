/**
 * @description 是否为最新-枚举类
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 是否为最新-枚举类
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: SignCurrentEnum
 * @author: FengLai_Gong
 */
public enum SignCurrentEnum {

    IS_CURRENT(1,"是"),
    NOT_CURRENT(2,"否"),

    ;
    private Integer code  ;

    private String name ;

    SignCurrentEnum(Integer code, String name){
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