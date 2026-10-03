/**
 * @description 用户认证角色枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: AuthTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: AuthTypeEnum
 * @author: FengLai_Gong
 */
public enum AuthTypeEnum {

    TENANT_USER(1,"用户(租户下用户)"),
    DEPART(2,"部门"),
    ROLE(3,"3角色"),

    ;

    private Integer code  ;

    private String name ;

    AuthTypeEnum(Integer code, String name){
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