/**
 * @description 业务开关枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: BeforeSignApproveTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: BeforeSignApproveTypeEnum
 * @author: FengLai_Gong
 */
public enum SignOnOrOffEnum {


    YES(1,"是"),
    NO(2,"否"),

    ;
    private Integer code  ;

    private String name ;

    SignOnOrOffEnum(Integer code, String name){
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