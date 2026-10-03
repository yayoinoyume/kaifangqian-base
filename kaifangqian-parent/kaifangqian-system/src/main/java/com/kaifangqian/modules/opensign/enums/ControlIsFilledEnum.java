/**
 * @description 填写状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 填写控件是否已填充
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ControlIsFilledEnum
 * @author: FengLai_Gong
 */
public enum ControlIsFilledEnum {


    IS(1,"已填充"),
    NOT(2,"未填写"),


    ;

    private Integer code  ;

    private String name ;

    ControlIsFilledEnum(Integer code, String name){
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