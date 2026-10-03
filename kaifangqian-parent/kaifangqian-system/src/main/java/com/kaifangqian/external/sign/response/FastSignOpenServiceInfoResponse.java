/**
 * @description 快捷签署服务开通响应对象
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class FastSignOpenServiceInfoResponse {

    private Integer status;

    private String resultMessage;

    private String openUrl;

}
