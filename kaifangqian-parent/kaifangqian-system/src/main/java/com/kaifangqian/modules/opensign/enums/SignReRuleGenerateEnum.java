/**
 * @description 业务线配置-单号生成类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 业务线配置-单号生成类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReRuleTypeEnum
 * @author: FengLai_Gong
 */
public enum SignReRuleGenerateEnum {

    CUSTOM(1,"自定义"),
    RULE(2,"规则"),
    ;

    private Integer code  ;

    private String name ;

    SignReRuleGenerateEnum(Integer code, String name){
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