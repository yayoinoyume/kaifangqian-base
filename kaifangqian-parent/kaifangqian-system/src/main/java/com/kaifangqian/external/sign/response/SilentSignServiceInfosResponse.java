/**
 * @description 静默签开通信息响应对象
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;

import java.util.List;
/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class SilentSignServiceInfosResponse {

    private Integer status;

    private String resultMessage;

    List<SilentSignAuthorizeRecordResponse> silentSignAuthorizes;

}
