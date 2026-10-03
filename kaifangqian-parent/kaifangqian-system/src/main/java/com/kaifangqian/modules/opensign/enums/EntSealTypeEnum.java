/**
 * @description 印章类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: EntSealTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: EntSealTypeEnum
 * @author: FengLai_Gong
 */
public enum EntSealTypeEnum {


    COMPANY_SEAL(1,"公章"),
    FINANCE_SEAL(2,"财务专用章"),
    CONTRACT_SEAL(3,"合同专用章"),
    PERSONNEL_SEAL(4,"人事专用章"),

    OTHER(5,"其他"),

    LEGAL_PERSON(6,"法人章"),


    ;
    EntSealTypeEnum(Integer code ,String name){
        this.code = code;
        this.name = name;
    }

    private Integer code ;
    private String name ;

    public String getName(){
        return this.name;
    }

    public Integer getCode(){
        return this.code;
    }




}