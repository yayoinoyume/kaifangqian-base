package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 字典类型
 */
public enum AppAndVersionType {
    GROUP(1, "团队"),
    PERSONAL(2, "个人"),
    ALL(0, "所有");

    private Integer type;

    private String name;

    AppAndVersionType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public AppAndVersionType setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AppAndVersionType setName(String name) {
        this.name = name;
        return this;
    }
}