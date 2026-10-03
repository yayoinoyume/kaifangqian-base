/**
 * @description 签署业务操作类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: OperateTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: OperateTypeEnum
 * @author: FengLai_Gong
 */
public enum OperateTypeEnum {


    WRITE(1,"填写"),
    SIGN(2,"签署"),
    SIGN_NO_CERT(3,"无证书签署"),
    APPROVE(4,"审批"),

    ;

    private Integer code  ;

    private String name ;

    OperateTypeEnum(Integer code, String name){
        this.code = code ;
        this.name = name;
    }


    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }


    public static OperateTypeEnum getByCode(Integer code){
        OperateTypeEnum[] values = OperateTypeEnum.values();
        for(OperateTypeEnum operateTypeEnum : values){
            if(code == operateTypeEnum.getCode()){
                return operateTypeEnum ;
            }
        }
        return null ;
    }


}