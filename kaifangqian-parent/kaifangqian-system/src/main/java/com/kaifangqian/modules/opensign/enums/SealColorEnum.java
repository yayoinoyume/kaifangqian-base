/**
 * @description 签章颜色枚举类
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 签章颜色枚举类
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: SealColorEnum
 * @author: FengLai_Gong
 */
public enum SealColorEnum {

    RED(1,"红色"),
    BLUE(2,"蓝色"),
    BLACK(3,"黑色"),

    ;

    private Integer code ;
    private String name ;

    SealColorEnum(Integer code, String name){
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