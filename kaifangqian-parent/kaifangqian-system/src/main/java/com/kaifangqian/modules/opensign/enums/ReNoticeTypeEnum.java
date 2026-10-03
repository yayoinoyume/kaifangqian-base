/**
 * @description 签署通知类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

public enum ReNoticeTypeEnum {

    WRITE_TASK_PHONE("write_task_phone", "文件填写短信通知"),
    SIGN_TASK_IN_PHONE("sign_task_in_phone", "文件签署（发起方内部）短信通知"),
    APPROVE_TASK_IN_PHONE("approve_task_in_phone", "文件审批（发起方内部）短信通知"),
    SIGN_TASK_OUT_PHONE("sign_task_out_phone", "文件签署（外部接收方）短信通知"),
    COPY_BEGIN_PHONE("copy_begin_phone", "文件抄送（发起方内部）短信通知"),
    COPY_SIGN_PHONE("copy_sign_phone", "文件抄送（外部）短信通知"),
    WRITE_TASK_EMAIL("write_task_email", "文件填写邮件通知"),
    SIGN_TASK_IN_EMAIL("sign_task_in_email", "文件签署（发起方内部）邮件通知"),
    APPROVE_TASK_IN_EMAIL("approve_task_in_email", "文件审批（发起方内部）邮件通知"),
    SIGN_TASK_OUT_EMAIL("sign_task_out_email", "文件签署（外部接收方）邮件通知"),
    COPY_BEGIN_EMAIL("copy_begin_email", "文件抄送（发起方内部）邮件通知"),
    COPY_SIGN_EMAIL("copy_sign_email", "文件抄送（外部）邮件通知"),

    ;

    private String type;

    private String name;

    ReNoticeTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }


}