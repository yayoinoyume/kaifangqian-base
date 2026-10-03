/**
 * @description 签署回调请求参数
 */
package com.kaifangqian.external.sign.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignCallbackRequest {
    private String actionType;
    private String orderNo;
    private Integer orderStatus;
    private String unionId;
    private String tenantType;
    private String operatorUnionId;
    private String contractId;
    private String bizId;
    private String finalSignType;
    private String verifyTime;
}
