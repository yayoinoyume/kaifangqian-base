/**
 * @description 模板使用者角色枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignReAuthTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReAuthTypeEnum
 * @author: FengLai_Gong
 */
public enum SignTemplateAuthTypeEnum {

    MANAGER(1,"管理者"),
    USER(2,"使用者"),
    ;

    private Integer code  ;

    private String name ;

    SignTemplateAuthTypeEnum(Integer code, String name){
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