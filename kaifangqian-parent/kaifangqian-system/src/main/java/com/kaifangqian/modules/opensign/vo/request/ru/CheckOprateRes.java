/**
 * @description 任务属性
 */
package com.kaifangqian.modules.opensign.vo.request.ru;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/11/20  14:32
 * @description:
 */
@Data
public class CheckOprateRes {
    //意愿校验taskID
    private String confirmTaskId;
    //任务ID
    private String taskId;
    //实例ID
    private String signRuId;
    //是否为发起者
    private boolean startFlag;
    //是否可下载
    private boolean downloadFlag;
    //任务类型
    private String taskType;
}