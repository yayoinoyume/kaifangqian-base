/**
 * @description 资助审批电子签章系统服务开通状态响应数据
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class SignServiceOpenInfoResponse {

    /**
     * 开通状态码：0:未开启；1:已开启；-1
     */
    private Integer status;

    private String deadline;

    private String resultMessage;

}
