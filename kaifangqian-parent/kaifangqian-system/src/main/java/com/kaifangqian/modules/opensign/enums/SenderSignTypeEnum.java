/**
 * @description 盖章方式枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SenderSignTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SenderSignTypeEnum
 * @author: FengLai_Gong
 */
public enum SenderSignTypeEnum {


    AUTO(1,"自动盖章"),
    APPOINT(2,"指定位置盖章"),

    ;
    private Integer code  ;

    private String name ;

    SenderSignTypeEnum(Integer code, String name){
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