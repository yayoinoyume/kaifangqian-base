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
public enum ApplyErrorEnum {

    NO_APPLY_DATA(1,"申请记录不存在"),
    NO_BUSINESS_DATA(1,"业务数据不存在"),
    UPDATE_ERROR(1,"业务数据更新失败"),

    ;

    private Integer code  ;

    private String name ;

    ApplyErrorEnum(Integer code, String name){
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