/**
 * @description 电子签名开通实名认证状态枚举
 */
package com.kaifangqian.external.enums;

/**
 * @author : wwt
 * create at: 2025/6/6
 */
public enum YunDunAuthStatus {
    CANCELED(3, "已撤销"),
    SUCCESS(1, "已认证完成"),
    PROCESSING(2, "认证中（自主认证中、认证审核中（针对于人工审核方式）、审核未通过（针对于人工审核方式）、认证授权审批中、认证授权审批未通过）"),
    INVALID(4, "已失效"),
    FRISTVERIFY(1, "首次认证"),
    UPDATE(2, "更新认证");

    private Integer type;

    private String name;

    YunDunAuthStatus(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public YunDunAuthStatus setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public YunDunAuthStatus setName(String name) {
        this.name = name;
        return this;
    }
}