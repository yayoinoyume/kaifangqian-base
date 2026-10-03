/**
 * @description 开通快捷签署服务返回结果
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class FreeSignAuthorizesRecordResponse {

    private String unionId;

    private String openTime;

    private String deadline;

    private Integer status;

}
