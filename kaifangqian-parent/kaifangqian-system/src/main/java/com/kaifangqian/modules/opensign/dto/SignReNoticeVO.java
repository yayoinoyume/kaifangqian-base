/**
 * @description 签署通知标识
 */
package com.kaifangqian.modules.opensign.dto;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2024/6/28  10:25
 * @description:
 */
@Data
public class SignReNoticeVO {
    //业务线唯一标识
    private String signReId;
    //文件填写标识短信
    private Boolean writeTaskFlagPhone;
    //文件签署（发起方内部）标识短信
    private Boolean signTaskInFlagPhone;
    //文件签署（外部接收方）标识短信
    private Boolean signTaskOutFlagPhone;
    //文件抄送（发起方内部）标识短信
    private Boolean copyBeginFlagPhone;
    //文件抄送（外部）标识短信
    private Boolean copySignFlagPhone;

    //文件填写标识邮件
    private Boolean writeTaskFlagEmail;
    //文件签署（发起方内部）标识邮件
    private Boolean signTaskInFlagEmail;
    //文件签署（外部接收方）标识邮件
    private Boolean signTaskOutFlagEmail;
    //文件抄送（发起方内部）标识邮件
    private Boolean copyBeginFlagEmail;
    //文件抄送（外部）标识邮件
    private Boolean copySignFlagEmail;
    //文件审批标识短信
    private Boolean approvalTaskFlagPhone;
    //文件审批标识邮件
    private Boolean  approvalTaskFlagEmail;


}