/**
 * @description 用户授权开通电子签服务
 */
package com.kaifangqian.external.auth.service;

import com.kaifangqian.external.auth.request.AuthCallbackRequest;
import com.kaifangqian.external.auth.request.AuthOrderInfoRequest;
import com.kaifangqian.external.auth.response.IdentityAuthInfoForGetResponse;
import com.kaifangqian.external.auth.response.IdentityAuthInfoForQueryResponse;
import com.kaifangqian.external.auth.response.IdentityAuthResponse;
import com.kaifangqian.external.base.CommonRequest;
import com.kaifangqian.external.base.CommonResult;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.external.auth.request.*;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
public interface IdentityAuthExternal {

    /**
     * 获取个人实名认证链接地址
     * @return
     */
    IdentityAuthResponse personalIdentityAuth(String callbackPage) throws Exception;

    /**
     * 查询实名认证信息
     * @return
     */
    Result<?> queryIdentityAuthInfo(String orderNo) throws Exception;

    /**
     * 查询实名认证信息
     * @return
     */
    Result<?> getIdentityAuthInfo(String unionId) throws Exception;

    /**
     * 获取个人实名认证变更链接地址
     * @return
     */
    IdentityAuthResponse personalIdentityAuthUpdate(String callbackPage) throws Exception;


    /**
     * 获取企业实名认证链接地址
     * @param callbackPage
     * @return
     */
    IdentityAuthResponse companyIdentityAuth(String callbackPage) throws Exception;

    /**
     * 获取企业实名认证变更链接地址
     * @param callbackPage
     * @return
     */
    IdentityAuthResponse companyIdentityAuthUpdate(String callbackPage) throws Exception;


    /**
     * 查询实名认证信息
     * @param request
     * @return
     */
    CommonResult<IdentityAuthInfoForQueryResponse> queryIdentityAuthInfo(CommonRequest<AuthOrderInfoRequest> request);

    /**
     * 获取实名认证信息
     * @param request
     * @return
     */
    CommonResult<IdentityAuthInfoForGetResponse> getIdentityAuthInfo(CommonRequest<AuthOrderInfoRequest>  request);


    /**
     * 更新个人实名认证
     * @param request
     * @return
     */
    Result<?> updateIdentityAuth(AuthCallbackRequest request) throws Exception;



}
