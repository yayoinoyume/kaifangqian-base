/**
 * @description 抄送状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignCcedOpportunityTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignCcedOpportunityTypeEnum
 * @author: FengLai_Gong
 */
public enum SignCcedOpportunityTypeEnum {


    AFTER_START(1,"文件发起时"),
    AFTER_SIGN(2,"文件签署完成时"),

    ;
    private Integer code  ;

    private String name ;

    SignCcedOpportunityTypeEnum(Integer code, String name){
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