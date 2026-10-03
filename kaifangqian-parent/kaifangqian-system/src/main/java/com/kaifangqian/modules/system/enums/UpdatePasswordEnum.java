package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/8/1  17:06
 * @description: 修改密码枚举
 */
public enum UpdatePasswordEnum {
    PASSWORD("password", "通过原始密码修改"),
    PHONE("phone", "通过手机号修改"),
    EMIAL("email", "通过邮箱修改");

    private String type;

    private String name;

    UpdatePasswordEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public UpdatePasswordEnum setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdatePasswordEnum setName(String name) {
        this.name = name;
        return this;
    }
}