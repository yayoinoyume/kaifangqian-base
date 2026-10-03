/**
 * @description 签署状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: DocStatusEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: DocStatusEnum
 * @author: FengLai_Gong
 */
public enum DocStatusEnum {


    TO_BE_SUMMIT(1,"待发起"),

    TO_BE_RE_SUMMIT(2,"待重新发起"),

    TO_BE_APPROVAL(3,"待审批"),

    APPROVAL_FAILED(4,"审批未通过"),

    TO_BE_SIGN(5,"待签章"),

    SIGN_FAILED(6,"签署失败"),

    FINISHED(7,"已完成"),

    EXPIRED(8,"已过期"),

    CANCELED(9,"作废"),

    ;

    DocStatusEnum(Integer code ,String name){
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

