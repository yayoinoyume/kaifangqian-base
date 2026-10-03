/**
 * @description 签署线程本地变量
 */
package com.kaifangqian.modules.opensign.dto;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/3/16  10:21 AM
 * @description: 签署线程本地变量
 */
@Data
public class SignTaskThreadlocalVO {
    //任务ID
    private String taskId;
    //任务类型
    private String taskType;
    //实例ID
    private String signRuId;
    //节点用户类型
    private Integer userType;
    //用户节点ID
    private String userTaskId;
    //签署订单号
    private String signOrderNo;
}