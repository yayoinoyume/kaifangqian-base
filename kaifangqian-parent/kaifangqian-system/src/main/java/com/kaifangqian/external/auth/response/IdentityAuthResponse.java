/**
 * @description 电子签服务开通，个人实名开通业务逻辑处理
 */
package com.kaifangqian.external.auth.response;

import lombok.Data;
/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class IdentityAuthResponse {

    private String orderNo;

    private String authUrl;

    /**
     * 认证页面逻辑状态,1：已实名认证，本地刷新页面；0:未实名，打开云盾认证页面;-1:云盾订单返回的实名主体与当前登录人不一致，或用户类型不一致
     */
    private Integer authStatus;

    private String resultMessage;

}
