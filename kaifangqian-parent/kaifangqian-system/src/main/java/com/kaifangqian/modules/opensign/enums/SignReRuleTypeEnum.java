/**
 * @description 业务线配置-单号生成规则类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 业务线配置-单号生成规则类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReRuleTypeEnum
 * @author: FengLai_Gong
 */
public enum SignReRuleTypeEnum {

    SIGN_RE_CODE(1,"文件编号"),
    SIGN_RE_SUBJECT(2,"文件主题"),
    ;

    private Integer code  ;

    private String name ;

    SignReRuleTypeEnum(Integer code, String name){
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