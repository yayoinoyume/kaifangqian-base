/**
 * @description 申请错误枚举类
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: ApplyErrorEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ApplyErrorEnum
 * @author: FengLai_Gong
 */
public enum SignFinishTypeEnum {

    MANUAL_FINISH(0,"手动结束"),
    AUTO_FINISH(1,"自动结束"),

    ;

    private Integer code  ;

    private String name ;

    SignFinishTypeEnum(Integer code, String name){
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