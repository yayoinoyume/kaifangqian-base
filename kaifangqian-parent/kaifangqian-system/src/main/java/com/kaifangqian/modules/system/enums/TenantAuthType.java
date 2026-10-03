package com.kaifangqian.modules.system.enums;

public enum TenantAuthType {
    CREATED(1, "首次认证"),
    CHANGE(2, "已认证成功，变更认证"),
    RELOAD(3, "重新实名认证"),
    ;

    private Integer type;

    private String name;

    TenantAuthType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public TenantAuthType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TenantAuthType setName(String name) {
        this.name = name;
        return this;
    }
}