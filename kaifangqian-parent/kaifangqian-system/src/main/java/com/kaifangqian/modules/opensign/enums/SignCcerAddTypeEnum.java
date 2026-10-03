/**
 * @description 抄送状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignCcerAddTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignCcerAddTypeEnum
 * @author: FengLai_Gong
 */
public enum SignCcerAddTypeEnum {

    RE(1,"业务线配置"),
    CUSTOM(2,"用户新增"),

    ;
    private Integer code  ;

    private String name ;

    SignCcerAddTypeEnum(Integer code, String name){
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