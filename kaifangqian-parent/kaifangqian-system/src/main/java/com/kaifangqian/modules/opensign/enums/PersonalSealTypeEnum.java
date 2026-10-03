/**
 * @description 个人签名生成类型
 */
package com.kaifangqian.modules.opensign.enums;

public enum PersonalSealTypeEnum {

    NOLIMIT("NOLIMIT", "不限制"),
    TEMPLATE("TEMPLATE", "模板签名"),
    HAND("HAND", "手写签名"),
    ;

    private String type;

    private String name;

    PersonalSealTypeEnum(String type, String name) {
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