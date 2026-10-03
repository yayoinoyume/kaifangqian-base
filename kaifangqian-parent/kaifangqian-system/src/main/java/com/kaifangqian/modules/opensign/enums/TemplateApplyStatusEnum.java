/**
 * @description 模板申请状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: TemplateApplyStatusEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: TemplateApplyStatusEnum
 * @author: FengLai_Gong
 */
public enum TemplateApplyStatusEnum {


    INIT(0,"初始数据"),

    TO_BE_SUMMIT(1,"待提交"),

    TO_BE_RE_SUMMIT(2,"待重新提交"),

    TO_BE_APPROVAL(3,"待审批"),

    APPROVAL_FAILED(4,"审批未通过"),

    APPROVAL_SUCCESS(5,"审批通过"),

    CANCELED(6,"作废"),

    ;


    public static String getName(Integer code) {
        TemplateApplyStatusEnum[] values = TemplateApplyStatusEnum.values();
        for(TemplateApplyStatusEnum templateApplyStatusEnum : values){
            if(templateApplyStatusEnum.getCode().equals(code)){
                return templateApplyStatusEnum.getName();
            }
        }
        return null ;
    }

    TemplateApplyStatusEnum(Integer code ,String name){
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