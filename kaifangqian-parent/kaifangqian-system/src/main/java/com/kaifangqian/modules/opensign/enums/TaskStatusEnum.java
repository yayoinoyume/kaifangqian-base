/**
 * @description 签署任务办理状态类型
 */
package com.kaifangqian.modules.opensign.enums;

public enum TaskStatusEnum {
    WAIT_TO_DO(1, "待办理"),
    DONE(2, "已办理"),
    ;

    private Integer code;

    private String name;

    TaskStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}