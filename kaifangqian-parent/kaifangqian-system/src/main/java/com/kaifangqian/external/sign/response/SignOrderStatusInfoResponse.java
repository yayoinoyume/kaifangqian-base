/**
 * @description 资助审批电子签章系统订单状态响应信息
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class SignOrderStatusInfoResponse {

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 业务状态
     */
    private Integer status;

    /**
     * 业务结果信息
     */
    private String resultMessage;

    /**
     * 签署taskId
     */
    private String taskId;

}
