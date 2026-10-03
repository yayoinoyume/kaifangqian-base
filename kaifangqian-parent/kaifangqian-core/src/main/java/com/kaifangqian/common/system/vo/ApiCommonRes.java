/**
 * @description 通用返回
 */
package com.kaifangqian.common.system.vo;

import com.kaifangqian.common.constant.ApiCode;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @author : zhenghuihan
 * create at: 2023/12/26
 */
@Data
// @ApiModel(value = "接口返回对象", description = "接口返回对象")
public class ApiCommonRes<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 返回代码
     */
    // @ApiModelProperty(value = "返回代码")
    private Integer code = 10000;

    /**
     * 返回处理消息
     */
    // @ApiModelProperty(value = "返回处理消息")
    private String message = "";

    /**
     * 返回数据对象 data
     */
    // @ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    // @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public ApiCommonRes() {
    }

    public ApiCommonRes(T result) {
        this.result = result;
    }

    public ApiCommonRes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiCommonRes(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> ApiCommonRes<T> error(ApiCode apiCode) {
        return new ApiCommonRes(apiCode.getCode(), apiCode.getTemplate(), null);
    }

    public static <T> ApiCommonRes<T> ok() {
        return new ApiCommonRes(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getTemplate());
    }

    public static <T> ApiCommonRes<T> ok(T data) {
        return new ApiCommonRes(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getTemplate(), data);
    }


    public static <T> ApiCommonRes<T> of(T data, ApiCode code) {
        return new ApiCommonRes(code.getCode(), code.getTemplate(), data);
    }


    public static <T> ApiCommonRes<T> of(ApiCode code) {
        return new ApiCommonRes(code.getCode(), code.getTemplate(), null);
    }

    public static <T> ApiCommonRes<T> of(Integer code, String message) {
        return new ApiCommonRes(code, message, null);
    }
}