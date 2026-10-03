/**
 * @description 电子签业务逻辑接口
 */
package com.kaifangqian.external.sign.service;

import com.kaifangqian.external.sign.request.AutoSignDocumentRequest;
import com.kaifangqian.external.sign.request.SignCallbackRequest;
import com.kaifangqian.external.sign.request.SignOrderRequest;
import com.kaifangqian.external.sign.request.VerifySignDocumentRequest;
import com.kaifangqian.external.sign.response.AuthSignDocumentResponse;
import com.kaifangqian.external.sign.response.AutoSignDocumentResponse;
import com.kaifangqian.external.sign.response.SignOrderServiceInfoResponse;
import com.kaifangqian.external.sign.response.SignOrderStatusInfoResponse;
import com.kaifangqian.common.vo.Result;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
public interface SignServiceExternal {

    /**
     * 获取签署意愿校验链接
     * @return
     */
    SignOrderServiceInfoResponse generateSignOrderAndGetSignAuthUrl(SignOrderRequest signOrderRequest) throws Exception;

    /**
     * 提交文件hash值进行签署--意愿验证签署
     * @return
     */
    AuthSignDocumentResponse submitAuthHashSign(VerifySignDocumentRequest verifySignDocumentRequest) throws Exception;

    /**
     * 提交文件hash值进行签署--静默签署
     * @return
     */
    AutoSignDocumentResponse submitAutoHashSign(AutoSignDocumentRequest autoSignDocumentRequest) throws Exception;

    /**
     * 获取签署订单状态
     * @return
     */
    SignOrderStatusInfoResponse getSignOrderStatus(String orderNo) throws Exception;

    /**
     * 更新签署订单状态，完成签署
     * @param request
     * @throws Exception
     */
    Result<?> updateSignUserConfirmStatus(SignCallbackRequest request) throws Exception;
}
