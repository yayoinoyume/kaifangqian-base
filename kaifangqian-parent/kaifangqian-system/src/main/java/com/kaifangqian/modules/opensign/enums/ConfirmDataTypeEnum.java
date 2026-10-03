/**
 * @description 验证类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

public enum ConfirmDataTypeEnum {

    CODE("code", "验证码"),
    PASSWORD("password", "密码"),
    FILE("file", "文件"),
    ;

    private String type;

    private String name;

    ConfirmDataTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}