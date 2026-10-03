/**
 * @description 意愿验证枚举
 */
package com.kaifangqian.modules.opensign.enums;

public enum PersonalSignAuthTypeEnum {

    REQUIRED("required", "须实名认证"),

    ALLOWED("allowed", "允许不实名认证"),

    NOT_REQUIRED("not_required", "无需实名认证"),
    ;

    private String type;

    private String name;

    PersonalSignAuthTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static PersonalSignAuthTypeEnum getByType(String type) {
        for (PersonalSignAuthTypeEnum confirmType : PersonalSignAuthTypeEnum.values()) {
            if (confirmType.getType().equals(type)) {
                return confirmType;
            }
        }
        return null;
    }

}