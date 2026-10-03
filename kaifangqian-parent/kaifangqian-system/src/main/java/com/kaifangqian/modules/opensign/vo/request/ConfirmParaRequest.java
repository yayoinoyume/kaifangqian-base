/**
 * @description 意愿校验确认请求参数
 */
package com.kaifangqian.modules.opensign.vo.request;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2024/4/7  15:41
 * @description:意愿校验确认请求参数
 */
@Data
public class ConfirmParaRequest {
    private String orderNo;

    private String confirmType;
}