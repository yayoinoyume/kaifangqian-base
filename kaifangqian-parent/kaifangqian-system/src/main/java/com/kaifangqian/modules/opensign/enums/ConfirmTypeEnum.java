/**
 * @description 意愿验证枚举
 */
package com.kaifangqian.modules.opensign.enums;

public enum ConfirmTypeEnum {

    PAASWORD("password", "签署密码"),

    PHONE_EMAIL("phone_email", "验证码"),

    FACE("face", "人脸识别认证"),

    DOUBLE("double", "双重校验（验证码+签署密码）"),

    NONE("none", "不需要"),
    ;

    private String type;

    private String name;

    ConfirmTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static ConfirmTypeEnum getByType(String type) {
        for (ConfirmTypeEnum confirmType : ConfirmTypeEnum.values()) {
            if (confirmType.getType().equals(type)) {
                return confirmType;
            }
        }
        return null;
    }

}