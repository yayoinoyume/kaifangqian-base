package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 字典类型
 */
public enum TenantAppStatus {
    ENABLE(1, "可用"),
    DISABLE(2, "不可用"),
    STOP(3, "租户停用");

    private Integer type;

    private String name;

    TenantAppStatus(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public TenantAppStatus setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TenantAppStatus setName(String name) {
        this.name = name;
        return this;
    }
}