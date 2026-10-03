package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 字典类型
 */
public enum AuthGroupType {
    GROUP(0, "分组"),
    ALL(1, "系统全部"),
    BASE(2, "系统基础"),
    CUSTOMIZE(3, "系统自定义"),
    USERADD(4, "用户新增");

    private Integer type;

    private String name;

    AuthGroupType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public AuthGroupType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthGroupType setName(String name) {
        this.name = name;
        return this;
    }
}