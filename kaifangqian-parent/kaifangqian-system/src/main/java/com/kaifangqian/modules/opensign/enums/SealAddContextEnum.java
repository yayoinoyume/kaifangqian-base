/**
 * @description 个人印章名样式枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SealAddContextEnum
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: SealAddContextEnum
 * @author: FengLai_Gong
 */
public enum SealAddContextEnum {

    NOTHING(1,"无添加"),
    YIN(2,"印"),
    ZHI_YIN(3,"之印"),
    ;

    private Integer code ;
    private String name ;

    SealAddContextEnum(Integer code, String name){
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