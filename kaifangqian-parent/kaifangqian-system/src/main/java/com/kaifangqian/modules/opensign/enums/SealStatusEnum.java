/**
 * @description 签章状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 签章状态
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SealStatusEnum
 * @author: FengLai_Gong
 */
public enum SealStatusEnum {


    ENABLE(1,"有效"),
    UN_ENABLE(2,"失效"),

    ;
    private Integer code  ;

    private String name ;

    SealStatusEnum(Integer code, String name){
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