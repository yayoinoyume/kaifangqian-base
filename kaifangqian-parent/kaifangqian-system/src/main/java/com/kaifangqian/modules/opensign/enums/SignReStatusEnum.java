/**
 * @description 业务线启用状态类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignReStatusEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReStatusEnum
 * @author: FengLai_Gong
 */
public enum SignReStatusEnum {


    ENABLE(1,"启用"),
    UN_ENABLE(2,"停用"),
    ;

    private Integer code  ;

    private String name ;

    SignReStatusEnum(Integer code, String name){
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