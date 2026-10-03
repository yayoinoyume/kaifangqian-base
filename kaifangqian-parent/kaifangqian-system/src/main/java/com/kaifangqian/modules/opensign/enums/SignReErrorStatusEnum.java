/**
 * @description 签署异常类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignReErrorStatusEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReErrorStatusEnum
 * @author: FengLai_Gong
 */
public enum SignReErrorStatusEnum {

    NO(2,"无异常"),

    AUTO_SIGN_ERROR(1,"组织签章【自动盖章】的签署节点未指定签署位置，请先指定签署位置"),
    WRITE_ERROR(3,"文档填写参数存在部分参数未指定填写方，请先指定"),
    ALL_ERROR(4,"1、组织签章【自动盖章】的签署节点未指定签署位置，请先指定签署位置；\n" + "2、文档填写参数存在部分参数未指定填写方，请先指定；"),


            ;
    private Integer code  ;

    private String name ;

    SignReErrorStatusEnum(Integer code, String name){
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