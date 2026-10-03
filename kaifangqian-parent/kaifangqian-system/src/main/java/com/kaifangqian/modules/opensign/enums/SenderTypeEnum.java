/**
 * @description 发起方签署角色类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SenderTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SenderTypeEnum
 * @author: FengLai_Gong
 */
public enum SenderTypeEnum {


    OPERATOR(1,"经办人签字","AGENT_SIGN"),
    LEGAL_PERSON(2,"法人签字","LEGAL_PERSON_SIGN"),
    PERSONAL(3,"个人签字","PERSONAL_SIGN"),
    ENTERPRISE(4,"组织签章","ENTERPRISE_SEAL"),
    APPROVER(5,"审批人审批","APPROVER_CHECK"),

    ;
    private Integer code  ;

    private String name ;

    private String apiName ;
    public String getApiName(){
        return this.apiName;
    }

    SenderTypeEnum(Integer code, String name){
        this.code = code ;
        this.name = name;
    }

    SenderTypeEnum(Integer code, String name,String apiName){
        this.code = code ;
        this.name = name;
        this.apiName = apiName;
    }


    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }


    public static SenderTypeEnum getByCode(Integer code){
        SenderTypeEnum[] values = SenderTypeEnum.values();
        for(SenderTypeEnum senderTypeEnum : values){
            if(code == senderTypeEnum.getCode()){
                return senderTypeEnum ;
            }
        }
        return null ;
    }


}