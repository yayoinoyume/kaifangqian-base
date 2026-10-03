/**
 * @description 控件文字对齐方式枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 控件文字对齐方式
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: ControlAlignment
 * @author: FengLai_Gong
 */
public enum ControlAlignment {

    ALIGN_LEFT(0,"left"),
    ALIGN_CENTER(1,"center"),
    ALIGN_RIGHT(2,"right"),


    ;

    private Integer code  ;

    private String name ;

    ControlAlignment(Integer code, String name){
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