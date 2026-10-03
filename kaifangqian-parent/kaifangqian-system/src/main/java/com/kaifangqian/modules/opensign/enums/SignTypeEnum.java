/**
 * @description 签署校验类型
 */
package com.kaifangqian.modules.opensign.enums;

public enum SignTypeEnum {
    AUTH_SIGN("auth_sign", "意愿校验签署"),
    AUTO_SIGN("aut0_sign", "静默签署"),
    ;

    private String type;

    private String name;

    SignTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getCode() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}