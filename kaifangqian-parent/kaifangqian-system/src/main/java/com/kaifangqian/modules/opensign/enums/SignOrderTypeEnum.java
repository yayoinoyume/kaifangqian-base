/**
 * @description 签署顺序枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 业务线配置-签署顺序
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReRuleTypeEnum
 * @author: FengLai_Gong
 */
public enum SignOrderTypeEnum {

    ORDER(1,"有序签署"),
    NO_ORDER(2,"无序签署"),
    ;

    private Integer code  ;

    private String name ;

    SignOrderTypeEnum(Integer code, String name){
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