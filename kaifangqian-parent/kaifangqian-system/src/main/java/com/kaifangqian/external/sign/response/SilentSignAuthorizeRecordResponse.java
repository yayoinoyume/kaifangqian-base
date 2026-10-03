/**
 * @description 静默签开通授权记录信息响应对象
 */
package com.kaifangqian.external.sign.response;

import lombok.Data;
/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class SilentSignAuthorizeRecordResponse {

    private String contactUnionId;

    private String contactName;

    private String openTime;

    private String deadline;

    private String email;

    private Integer status;

}
