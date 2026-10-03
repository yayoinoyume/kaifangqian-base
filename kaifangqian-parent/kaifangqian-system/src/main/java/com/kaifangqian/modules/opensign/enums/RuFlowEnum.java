/**
 * @description 签署流程类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: RuFlowEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: RuFlowEnum
 * @author: FengLai_Gong
 */
public enum RuFlowEnum {


    INITIATE_FLOW(1,"initiateFlow"),
    APPROVE(2,"approve"),
    REJECT(3,"reject"),

    ;

    private Integer code ;
    private String name ;

    RuFlowEnum(Integer code, String name){
        this.code = code ;
        this.name = name ;
    }

    public String getName(){
        return this.name ;
    }

    public Integer getCode(){
        return this.code ;
    }

}