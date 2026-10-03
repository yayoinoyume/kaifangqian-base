/**
 * @description 签署节点类型
 */
package com.kaifangqian.modules.opensign.enums;

public enum TaskTypeEnum {
    START_FLOW("start_flow", "发起节点"),
    INITIATE_FLOW("initiate_flow", "初始化流程"),
    B_START_TASK("b_start_task", "发起前审批节点"),
    REAL_START_FLOW("real_start_flow", "真正开始流程"),
    INITIATE_WRITE_TASK("initiate_write_task", "初始化填写节点"),
    WRITE_TASK("write_task", "填写节点"),
    B_SIGN_TASK("b_sign_task", "签署前审批节点"),
    INITIATE_SIGN_TASK("initiate_sign_task", "初始化签署节点"),
    SIGN_TASK("sign_task", "签署节点"),
    APPROVE_TASK("approve_task", "审批节点"),
    FINISH_FLOW("finish_flow", "结束流程"),
    ;

    private String type;

    private String name;

    TaskTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getCode() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}