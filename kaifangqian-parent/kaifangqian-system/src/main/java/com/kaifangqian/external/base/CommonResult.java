/**
 * @description 数据响应通用封装
 */
package com.kaifangqian.external.base;

import lombok.Data;

/**
 * @author : wwt
 * create at: 2025/6/6
 */
@Data
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T result;

    private long timestamp;
}
