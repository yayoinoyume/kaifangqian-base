/**
 * @description 签署人实名认证错误类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

public enum SignAuthCheckEnum {
    AUTH0(0, "信息错误"),
    AUTH1(1, "一致"),
    AUTH2(2, "账号不一致,目标账号存在"),
    AUTH3(3, "账号不一致，目标账号不存在"),
    AUTH4(4, "账号一致，身份不一致,个人身份存在"),
    AUTH5(5, "账号一致，身份不一致,个人身份不存在"),
    AUTH6(6, "账号一致，身份不一致,目标企业租户存在，但该账号不属于该企业"),

    AUTH7(7, "账号一致，身份不一致,目标企业租户存在，且该用户属于该企业"),
    AUTH8(8, "账号一致，身份不一致,目标企业租户不存在"),
    ;

    private Integer code;

    private String name;

    SignAuthCheckEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }


}