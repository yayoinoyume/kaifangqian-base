package com.kaifangqian.modules.system.enums;

public enum TenantAuthRealItemType {
    Item1(1, "实名认证"),
    Item2(2, "企业名称变更"),
    Item3(3, "企业法人变更"),
    Item4(4, "企业主体变更"),
    ;

    private Integer type;

    private String name;

    TenantAuthRealItemType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public TenantAuthRealItemType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TenantAuthRealItemType setName(String name) {
        this.name = name;
        return this;
    }
}