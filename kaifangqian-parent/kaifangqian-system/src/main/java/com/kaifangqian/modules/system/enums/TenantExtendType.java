package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 租户扩展类型
 */
public enum TenantExtendType {
    TYPE1(1, "个人"),
    TYPE2(2, "企业"),
    TYPE3(3, "工作站"),
    TYPE4(4, "版权局"),
    TYPE5(5, "区县版权局"),
    ;

    private Integer type;

    private String name;

    TenantExtendType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public TenantExtendType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TenantExtendType setName(String name) {
        this.name = name;
        return this;
    }
}