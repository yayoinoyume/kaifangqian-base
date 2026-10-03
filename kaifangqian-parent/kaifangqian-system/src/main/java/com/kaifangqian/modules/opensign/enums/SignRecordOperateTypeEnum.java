/**
 * @description 签署操作记录-操作类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 签署操作记录-操作类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignRecordOperateTypeEnum
 * @author: FengLai_Gong
 */
public enum SignRecordOperateTypeEnum {

    START("start","发起合同"),
    WRITE("write","填写"),
    PRIVATE_SIGN("private_sign","个人签名"),
    ENT_SIGN("ent_sign","组织签章"),
    REVOKE("revoke","撤销合同"),
    APPROVE("approve","签署审批"),
    ;

    private String type;

    private String name;

    SignRecordOperateTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static SignRecordOperateTypeEnum getByType(String type){
        for(SignRecordOperateTypeEnum typeEnum : SignRecordOperateTypeEnum.values()){
            if(type != null && type.equals(typeEnum.getType())){
                return typeEnum ;
            }
        }
        return null ;
    }

}