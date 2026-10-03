package com.kaifangqian.modules.system.enums;

/**
 * @author : zhenghuihan
 * create at:  2022/9/1  15:33
 * @description: 字典类型
 */
public enum AppAndVersionStatus {
    DRAFT(0, "草稿"),
    PUBLISHED(1, "已发布"),
    UNPUBLISHED(2, "未发布");

    private Integer type;

    private String name;

    AppAndVersionStatus(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public AppAndVersionStatus setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AppAndVersionStatus setName(String name) {
        this.name = name;
        return this;
    }
}