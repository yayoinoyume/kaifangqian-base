/**
 * @description 请求base实体
 */
package com.kaifangqian.modules.api.base;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2024/3/20  09:56
 * @description: 请求base实体
 */
@Data
public class ReqBaseVO {
    private String appAuthToken;
    private String operatorAccount;
    private String uniqueCode;
}