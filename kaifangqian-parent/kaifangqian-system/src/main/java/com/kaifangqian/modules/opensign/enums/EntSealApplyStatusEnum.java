/**
 * @description 企业印章申请状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: EntSealApplyStatusEnums
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: EntSealApplyStatusEnums
 * @author: FengLai_Gong
 */
public enum EntSealApplyStatusEnum {



    INIT(0,"初始数据"),

    TO_BE_SUMMIT(1,"待提交"),

    TO_BE_RE_SUMMIT(2,"待重新提交"),

    TO_BE_APPROVAL(3,"待审批"),

    APPROVAL_FAILED(4,"审批未通过"),

    APPROVAL_SUCCESS(5,"审批通过"),

    CANCELED(6,"作废"),

    ;


    EntSealApplyStatusEnum(Integer code ,String name){
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