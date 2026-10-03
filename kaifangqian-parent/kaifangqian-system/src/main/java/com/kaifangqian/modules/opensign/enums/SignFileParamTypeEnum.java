/**
 * @description 模板有无参数类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignFileParamTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignFileParamTypeEnum
 * @author: FengLai_Gong
 */
public enum SignFileParamTypeEnum {

    IS(1,"有参数"),
    NO(2,"无参数"),

    ;
    private Integer code  ;

    private String name ;

    SignFileParamTypeEnum(Integer code, String name){
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