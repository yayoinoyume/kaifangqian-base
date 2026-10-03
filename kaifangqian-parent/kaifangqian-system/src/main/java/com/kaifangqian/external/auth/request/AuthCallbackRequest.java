/**
 * @description 电子签服务开通，创建用户请求参数
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
public class AuthCallbackRequest {
    private String actionType;
    private String orderNo;
    private Integer orderStatus;
    private String unionId;
    private String contactUnionId;
    private Integer userType;
    private Integer bizType;
    private String personVerifyMethod;
    private String companyVerifyMethod;
    private String name;
    private String idCard;
    private Integer idCardType;
    private String mobile;
    private String bankCard;
    private String companyName;
    private String creditCode;
    private Integer companyType;
    private String createTime;
    private String verifyTime;
}
