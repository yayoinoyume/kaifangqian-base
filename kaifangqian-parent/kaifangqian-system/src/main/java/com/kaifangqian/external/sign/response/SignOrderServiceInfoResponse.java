/**
 * @description 电子签订单响应数据
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;
/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class SignOrderServiceInfoResponse {

    /**
     * 1：已认证，本地刷新页面；0:未意愿校验，打开云盾认证页面;
     */
    private Integer status;

    private String orderNo;

    private String resultMessage;

    private String signConfirmUrl;

}
