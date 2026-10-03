/**
 * @description 控件是否必填枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 控件是否必填枚举
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ControlIsRequiredEnum
 * @author: FengLai_Gong
 */
public enum ControlIsRequiredEnum {


    IS(1,"必填项"),
    NOT(2,"非必填项"),

    ;

    private Integer code  ;

    private String name ;

    ControlIsRequiredEnum(Integer code, String name){
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