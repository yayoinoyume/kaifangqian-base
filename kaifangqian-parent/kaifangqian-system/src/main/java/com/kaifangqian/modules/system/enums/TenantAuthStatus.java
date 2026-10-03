package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 租户审核状态
 */
public enum TenantAuthStatus {
    STATUS0(0, "未认证 "),
    STATUS1(1, "审核中"),
    STATUS2(2, "已认证"),
    STATUS3(3, "未通过"),

    ;

    private Integer status;

    private String name;

    TenantAuthStatus(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public TenantAuthStatus setType(Integer status) {
        this.status = status;
        return this;
    }

    public String getName() {
        return name;
    }

    public TenantAuthStatus setName(String name) {
        this.name = name;
        return this;
    }
}