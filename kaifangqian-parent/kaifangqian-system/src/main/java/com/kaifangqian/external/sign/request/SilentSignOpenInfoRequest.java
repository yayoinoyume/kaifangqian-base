/**
 * @description 静默签署服务开通请求参数
 */
package com.kaifangqian.external.sign.request;

import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class SilentSignOpenInfoRequest {

    private String unionId;
    private String contactUnionId;
    private String deadline;
    private String email;
    private String callbackPage;
    private String authCallbackUrl;

}
