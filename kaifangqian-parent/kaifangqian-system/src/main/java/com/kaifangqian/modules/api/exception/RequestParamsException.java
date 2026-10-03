/**
 * @description 异常接口，只有请求异常（未进入业务时）使用该exception抛出异常，业务中不可以使用。
 */
package com.kaifangqian.modules.api.exception;

import com.kaifangqian.common.constant.ApiCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create by zhenghuihan
 * @createTime 2024/3/21 18:25
 * @description 异常接口，只有请求异常（未进入业务时）使用该exception抛出异常，业务中不可以使用。
 */
@NoArgsConstructor
@Data
public class RequestParamsException extends RuntimeException {

    private ApiCode apiCode;

    private String token;

    private String reqPara;

    private String operatorAccount;

    private String uniqueCode;


    public RequestParamsException(String token, String operatorAccount, String uniqueCode, String reqPara, ApiCode apiCode, String msg) {
        super(msg);
        this.token = token;
        this.operatorAccount = operatorAccount;
        this.uniqueCode = uniqueCode;
        this.reqPara = reqPara;
        this.apiCode = apiCode;
    }

    public RequestParamsException(String token, String operatorAccount, String uniqueCode, String reqPara, ApiCode apiCode) {
        super(apiCode.getTemplate());
        this.token = token;
        this.operatorAccount = operatorAccount;
        this.uniqueCode = uniqueCode;
        this.reqPara = reqPara;
        this.apiCode = apiCode;
    }

    public RequestParamsException(String reqPara, ApiCode apiCode, String msg) {
        super(msg);
        this.apiCode = apiCode;
        this.reqPara = reqPara;
    }

    public RequestParamsException(String reqPara, ApiCode apiCode) {
        super(apiCode.getTemplate());
        this.apiCode = apiCode;
        this.reqPara = reqPara;
    }

    public RequestParamsException(ApiCode apiCode, String msg) {
        super(msg);
        this.apiCode = apiCode;
    }


    public RequestParamsException(ApiCode apiCode) {
        super(apiCode.getTemplate());
        this.apiCode = apiCode;
    }
}