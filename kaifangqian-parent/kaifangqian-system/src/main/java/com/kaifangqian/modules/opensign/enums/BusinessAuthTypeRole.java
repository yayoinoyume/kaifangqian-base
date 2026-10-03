/**
 * @description 业务管理员角色枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: BusinessAuthType
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: BusinessAuthType
 * @author: FengLai_Gong
 */
public enum BusinessAuthTypeRole {


    SEAL_MANAGER(1,"印章管理员"),

    SEAL_AUDITOR(2,"印章审计者"),

    SEAL_USER(3,"印章使用者"),


    TEMPLATE_MANAGE(1,"模板管理员"),

    TEMPLATE_USER(2,"模板使用员"),


    ;

    private Integer code  ;

    private String name ;

    BusinessAuthTypeRole(Integer code, String name){
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