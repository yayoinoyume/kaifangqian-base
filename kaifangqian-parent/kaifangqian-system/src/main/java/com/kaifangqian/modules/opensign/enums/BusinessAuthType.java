/**
 * @description 业务类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: BusinessAuthType
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: BusinessAuthType
 * @author: FengLai_Gong
 */
public enum BusinessAuthType {


    SEAL(1,"签章"),
    TEMPLATE(2,"模板"),
    DOC(3,"文档"),
    BUSINESS_LINE(4,"业务线"),

    ;

    private Integer code  ;

    private String name ;

    BusinessAuthType(Integer code, String name){
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