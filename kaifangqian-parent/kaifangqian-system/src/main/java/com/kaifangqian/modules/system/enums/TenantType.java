package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 字典类型
 */
public enum TenantType {
    GROUP(1, "团队"),
    PERSONAL(2, "个人"),
    UNKNOWN(3, "未知");

    private Integer type;

    private String name;

    TenantType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public TenantType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TenantType setName(String name) {
        this.name = name;
        return this;
    }

    public static TenantType getByType(Integer type) {
        for (TenantType tenantType : TenantType.values()) {
            if (tenantType.getType().equals(type)) {
                return tenantType;
            }
        }
        return TenantType.UNKNOWN;
    }
}