/**
 * @description 用户类型
 */
package com.kaifangqian.external.enums;

/**
 * @author : wwt
 * create at: 2025/6/6
 */
public enum YundunAuthUserType {
    GROUP(2, "团队"),
    PERSONAL(1, "个人"),
    UNKNOWN(3, "未知");

    private Integer type;

    private String name;

    YundunAuthUserType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public YundunAuthUserType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public YundunAuthUserType setName(String name) {
        this.name = name;
        return this;
    }

    public static YundunAuthUserType getByType(Integer type) {
        for (YundunAuthUserType tenantType : YundunAuthUserType.values()) {
            if (tenantType.getType().equals(type)) {
                return tenantType;
            }
        }
        return YundunAuthUserType.UNKNOWN;
    }
}