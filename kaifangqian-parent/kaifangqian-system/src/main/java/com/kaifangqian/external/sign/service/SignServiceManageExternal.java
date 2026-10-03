/**
 * @description 电子签服务（静默签管理、快捷签管理）业务逻辑接口
 */
package com.kaifangqian.external.sign.service;

import com.kaifangqian.external.sign.response.*;
import com.kaifangqian.external.sign.response.*;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
public interface SignServiceManageExternal {

    /**
     * 查询静默签署服务开通情况
     * @return
     */
    SignServiceOpenInfoResponse querySilentInfo() throws Exception;

    /**
     * 查询静默签署服务开通情况
     * @return
     */
    SignServiceOpenInfoResponse querySilentInfo(String tenantId) throws Exception;


    /**
     * 查询静默签署服务开通记录
     * @return
     */
    SilentSignServiceInfosResponse querySilentRecord() throws Exception;


    /**
     * 开通静默签署服务
     * @param callbackPage
     * @return
     */
    SilentSignOpenServiceInfoResponse openSilentSignService(String callbackPage) throws Exception;

    /**
     * 关闭静默签署服务
     * @return
     */
    SilentSignOpenServiceInfoResponse closeSilentSignService() throws Exception;

    /**
     * 查询免意愿快捷签署服务开通情况
     * @return
     */
    SignServiceOpenInfoResponse queryFastSignInfo() throws Exception;

    /**
     * 查询免意愿快捷签署服务开通情况
     * @return
     */
    SignServiceOpenInfoResponse queryFastSignInfo(String tenantId) throws Exception;

    /**
     * 查询免意愿快捷签署服务开通记录
     * @return
     */
    FastSignServiceInfosResponse queryFastSignRecord() throws Exception;

    /**
     * 开通免意愿快捷签署服务
     * @param callbackPage
     * @return
     */
    FastSignOpenServiceInfoResponse openFastSignService(String callbackPage) throws Exception;

    /**
     * 关闭免意愿快捷签署服务
     * @return
     */
    FastSignOpenServiceInfoResponse closeFastSignService() throws Exception;

    /**
     * 查询签署应用信息
     * @return
     */
    SignAppInfoResponse querySignAppInfo() throws Exception;
}
