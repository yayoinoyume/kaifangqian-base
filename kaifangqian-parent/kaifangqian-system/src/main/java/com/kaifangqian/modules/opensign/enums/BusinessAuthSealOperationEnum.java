/**
 * @description 印章业务类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: BusinessAuthSealOperationEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: BusinessAuthSealOperationEnum
 * @author: FengLai_Gong
 */
public enum BusinessAuthSealOperationEnum {


    SAVE(1,"印章新增或保存"),
    EDIT(2,"印章编辑"),
    CHANGE(3,"印章章面变更"),
    ENABLE(4,"印章启用"),
    UN_ENABLED(5,"印章停用"),
    DIVESTED(6,"印章收缴"),
    DESTRUCTION(7,"印章销毁"),

            ;

    private Integer code  ;

    private String name ;

    BusinessAuthSealOperationEnum(Integer code, String name){
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