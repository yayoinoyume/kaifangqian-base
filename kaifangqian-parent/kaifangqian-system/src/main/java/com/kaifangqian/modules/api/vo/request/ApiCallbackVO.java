/**
 * @description API接口合同签署回调对象
 */
package com.kaifangqian.modules.api.vo.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhenghuihan
 * create at:  2024/4/11  15:00
 * @description:
 */
@Data
public class ApiCallbackVO implements Serializable {
    private static final long serialVersionUID = -3571860201015990086L;

    private String id;
    /**
     * 回调url
     */
    private String callbackUrl;
    /**
     * 状态0:未回调 1、回调1次不成功 2、回调2次不成功 、3、回调3次不成功 4、回调4次不成功 10、回调成功
     */
    private Integer status;
    /**
     * 请求参数
     */
    private String reqPara;
}