/**
 * @description 开通快捷签署服务信息响应对象
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;

import java.util.List;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class FastSignServiceInfosResponse {

    private Integer status;

    private String resultMessage;

    List<FreeSignAuthorizesRecordResponse> freeSignAuthorizes;

}
