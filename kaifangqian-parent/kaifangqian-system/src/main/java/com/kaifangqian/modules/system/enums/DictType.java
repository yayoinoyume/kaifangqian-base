package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 字典类型
 */
public enum DictType {
    DICT("dict", "字典组"),
    GROUP("group", "字典分类");

    private String type;

    private String name;

    DictType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public DictType setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public DictType setName(String name) {
        this.name = name;
        return this;
    }
}