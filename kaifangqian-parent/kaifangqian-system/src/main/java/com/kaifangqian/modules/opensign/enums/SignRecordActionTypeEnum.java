/**
 * @description 签署操作记录-动作类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 签署操作记录-动作类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignRecordActionTypeEnum
 * @author: FengLai_Gong
 */
public enum SignRecordActionTypeEnum {


    START("start","发起合同"),
    SUBMIT_WRITE("submit_write","提交填写"),
    REJECT_WRITE("reject_write","拒绝填写"),
    SUBMIT_SIGN("submit_sign","签署"),
    REJECT_SIGN("reject_sign","拒绝签署"),
    AUTO_SIGN("auto_sign","自动盖章"),
    AUTH_SIGN("auth_sign","授权签署"),
    REVOKE("revoke","撤销合同"),
    APPROVE_CHECK("approve_check","审批通过"),
    REJECT_CHECK("reject_check","审批未通过"),

    ;

    private String type;

    private String name;

    SignRecordActionTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static SignRecordActionTypeEnum getByType(String type){
        for(SignRecordActionTypeEnum typeEnum : SignRecordActionTypeEnum.values()){
            if(type != null && type.equals(typeEnum.getType())){
                return typeEnum ;
            }
        }
        return null ;
    }
}