/**
 * @description 电子签服务开通，订单号码信息
 */
package com.kaifangqian.external.auth.request;

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
public class AuthOrderInfoRequest {

    private String orderNo;
}
