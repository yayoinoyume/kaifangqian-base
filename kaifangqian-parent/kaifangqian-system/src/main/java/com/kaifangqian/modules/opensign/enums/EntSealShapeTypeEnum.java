/**
 * @description 印章样式枚举
 */
package com.kaifangqian.modules.opensign.enums;
/**
 * @Description: 企业印章形状类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: EntSealShapeTypeEnum
 * @author: FengLai_Gong
 */
public enum EntSealShapeTypeEnum {


    CIRCULAR_STAR(1,"圆形有星"),
    ELLIPSE_STAR(2,"椭圆形有组织机构代码"),

    CIRCULAR(3,"圆形无星"),
    ELLIPSE(4,"椭圆形无组织机构代码"),


    ;
    EntSealShapeTypeEnum(Integer code ,String name){
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