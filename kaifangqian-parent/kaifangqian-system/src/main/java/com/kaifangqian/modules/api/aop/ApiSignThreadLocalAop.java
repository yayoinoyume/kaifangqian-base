/**
 * @description 处理签署线程本地变量
 *
 * Copyright (C) [2025] [版权所有者（北京资源律动科技有限公司）]. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * 注意：本代码基于 AGPLv3 协议发布。若通过网络提供服务（如 Web 应用），
 * 必须公开修改后的完整源代码（包括衍生作品），详见协议全文。
 */
package com.kaifangqian.modules.api.aop;

import com.alibaba.fastjson.JSONObject;
import com.kaifangqian.modules.api.entity.ApiNormalReq;
import com.kaifangqian.modules.api.exception.RequestParamsException;
import com.kaifangqian.modules.api.service.IApiNormalReqService;
import com.kaifangqian.modules.api.util.ApiSignature;
import com.kaifangqian.modules.api.service.IApiRelationLinkService;
import com.kaifangqian.modules.system.entity.ApiDeveloperManage;
import com.kaifangqian.modules.system.entity.SysTenantUser;
import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.common.constant.ApiCode;
import com.kaifangqian.common.constant.ApiConstants;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.system.vo.ProcTaskInfo;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.common.util.RequestHolder;
import com.kaifangqian.modules.opensign.dto.SignTaskInfo;
import com.kaifangqian.modules.opensign.dto.SignTaskThreadlocalVO;
import com.kaifangqian.modules.system.service.IApiDeveloperManageService;
import com.kaifangqian.modules.system.service.ISysTenantUserService;
import com.kaifangqian.modules.system.service.ISysUserService;
import com.kaifangqian.utils.MyStringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * create by zhenghuihan at 2022/3/16
 * @description 处理签署线程本地变量
 */
@Aspect
@Component
@Slf4j
@Data
public class ApiSignThreadLocalAop {

    @Autowired
    private IApiDeveloperManageService apiDeveloperManageService;
    @Autowired
    private ISysTenantUserService sysTenantUserService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IApiNormalReqService apiNormalReqService;
    @Autowired
    private IApiRelationLinkService apiRelationLinkService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ThreadLocal<String> requestBodyCache = new ThreadLocal<>();

    /**
     * 切入点
     * 根据路径切入
     */
    @Pointcut("execution(public * com.kaifangqian.modules.api.controller.*Controller.*(..))")
    public void local() {
    }

    /**
     * 前置操作
     *
     * @param
     */
    @Before("local()")
    public void before() {
        requestBodyCache.remove();
        MySecurityUtils.THREAD_LOCAL.remove();
        ProcTaskInfo.THREAD_LOCAL.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        request.setAttribute(ApiConstants.FROM_TYPE, ApiConstants.FROM_API);
        String path =request.getRequestURI() ;
        String sign = request.getHeader(ApiConstants.SIGN);
        String operatorAccount = null;
        String uniqueCode = null;
        String token = null;
        String content = null;
        boolean signVerified = false;
        // 防重放：请求头必须携带 timestamp + nonce，且两者都参与签名，服务端校验时间窗口并用 Redis 一次性消费 nonce
        String timestamp = request.getHeader(ApiConstants.TIMESTAMP);
        String nonce = request.getHeader(ApiConstants.NONCE);
        validateTimestampAndNonce(timestamp, nonce);
        if (request.getMethod().equalsIgnoreCase("POST") || request.getMethod().equalsIgnoreCase("PUT")) {
            // 获取请求体中的JSON数据
            try {
                String data = getRequestBody(request);
                requestBodyCache.set(data);
                content = cleanData(data);
                //校验token
                try {
                    JSONObject jsonObject = JSONObject.parseObject(data);
                    token = jsonObject.getString(ApiConstants.APP_AUTH_TOKEN);
                    operatorAccount = jsonObject.getString(ApiConstants.OPERATOR_ACCOUNT);
                    uniqueCode = jsonObject.getString(ApiConstants.UNIQUE_CODE);
                } catch (Exception e) {
                    //数据格式错误，不是json
                    throw new RequestParamsException(data, ApiCode.DATA_FORMAT_ERROR);
                }
                if (MyStringUtils.isBlank(token)) {
                    //没有token
                    throw new RequestParamsException(token, operatorAccount, uniqueCode, data, ApiCode.TOKEN_NULL);
                }
                ApiDeveloperManage developerManage = apiDeveloperManageService.getByToken(token);
                if (developerManage == null) {
                    //token无效
                    throw new RequestParamsException(token, operatorAccount, uniqueCode, data, ApiCode.TOKEN_INVALID);
                }
                if (developerManage.getStatus() != 1) {
                    //开发者被停用
                    throw new RequestParamsException(token, operatorAccount, uniqueCode, data, ApiCode.DEVELOPER_STOP);
                }
                //验签：POST/PUT 对原始请求体做 RSA2(SHA256withRSA) 验签，timestamp/nonce 一并纳入签名
                signVerified = verifySign(buildSignContent(data, timestamp, nonce), sign, developerManage.getPublicKey(), token, operatorAccount, uniqueCode, content);
            } catch (RequestParamsException e) {
                throw new RequestParamsException(token, operatorAccount, uniqueCode, content, e.getApiCode(), e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                //未知错误
                throw new RequestParamsException(token, operatorAccount, uniqueCode, content, ApiCode.UNKNOWN);
            }
        } else if (request.getMethod().equalsIgnoreCase("GET") || request.getMethod().equalsIgnoreCase("DELETE")) {
            Map<String, String> params = new HashMap<String, String>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                // 重复参数名无法与业务侧语义一一对应，直接拒绝，避免“签名参数”与“业务参数”不一致
                if (values != null && values.length > 1) {
                    throw new RequestParamsException(ApiCode.DATA_CHECK_ERROR, "重复参数：" + name);
                }
                params.put(name, values == null || values.length == 0 ? "" : values[0]);
            }
            content = params.toString();
            //校验token
            token = params.get(ApiConstants.APP_AUTH_TOKEN);
            operatorAccount = params.get(ApiConstants.OPERATOR_ACCOUNT);
            uniqueCode = params.get(ApiConstants.UNIQUE_CODE);
            if (MyStringUtils.isBlank(token)) {
                //没有token
                throw new RequestParamsException(token, operatorAccount, uniqueCode, content, ApiCode.TOKEN_NULL);
            }
            ApiDeveloperManage developerManage = apiDeveloperManageService.getByToken(token);
            if (developerManage == null) {
                //token无效
                throw new RequestParamsException(token, operatorAccount, uniqueCode, content, ApiCode.TOKEN_INVALID);
            }
            if (developerManage.getStatus() != 1) {
                //开发者被停用
                throw new RequestParamsException(token, operatorAccount, uniqueCode, content, ApiCode.DEVELOPER_STOP);
            }
            try {
                //验签：GET/DELETE 对规范化后的查询参数做 RSA2(SHA256withRSA) 验签，timestamp/nonce 一并纳入签名
                signVerified = verifySign(buildSignContent(ApiSignature.getSignCheckContent(params), timestamp, nonce), sign, developerManage.getPublicKey(), token, operatorAccount, uniqueCode, content);
            } catch (RequestParamsException e) {
                throw new RequestParamsException(token, operatorAccount, uniqueCode, content, e.getApiCode(), e.getMessage());
            }
        }
        //验签失败直接拒绝：未配置公钥、缺少签名或签名不匹配都不会放行
        if (!signVerified) {
            throw new RequestParamsException(token, operatorAccount, uniqueCode, content, ApiCode.DATA_CHECK_ERROR);
        }
        //验签通过后再一次性消费 nonce，避免攻击者用无效签名提前烧掉合法请求的 nonce
        consumeNonce(nonce);

        if (MyStringUtils.isNotBlank(operatorAccount)) {
            //初始化用户数据
            String tenantUserId = apiRelationLinkService.getSystemIdByExAccount(token, ApiConstants.EXTEND_TYPE_USER, operatorAccount);
            if (MyStringUtils.isNotBlank(tenantUserId)) {
                SysTenantUser tenantUser = sysTenantUserService.getById(tenantUserId);
                if (tenantUser != null) {
                    LoginUser loginUser = new LoginUser();
                    SysUser sysUser = sysUserService.getById(tenantUser.getUserId());
                    if (sysUser != null) {
                        BeanUtils.copyProperties(sysUser, loginUser);
                    }
                    loginUser.setTenantId(tenantUser.getTenantId());
                    loginUser.setTenantUserId(tenantUser.getId());
                    MySecurityUtils.THREAD_LOCAL.set(loginUser);
                }
            }

        }

        //初始化数据
        request.setAttribute(ApiConstants.APP_AUTH_TOKEN, token);
        request.setAttribute(ApiConstants.UNIQUE_CODE, uniqueCode);
        request.setAttribute(ApiConstants.OPERATOR_ACCOUNT, operatorAccount);
        request.setAttribute(ApiConstants.REQ_PARA, content);

        SignTaskThreadlocalVO threadlocalVO = new SignTaskThreadlocalVO();
        SignTaskInfo.THREAD_LOCAL.set(threadlocalVO);
    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("local()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }

    /**
     * 后置操作
     */
    @AfterReturning(value = "local()", returning = "obj")
    public void afterReturning(JoinPoint point, Object obj) {
        ApiNormalReq req = new ApiNormalReq();
        if(obj != null){
            req.setResPara(obj.toString());
        }
        apiNormalReqService.recordNormalReq(req);
        ProcTaskInfo.THREAD_LOCAL.remove();
        requestBodyCache.remove();
    }


    /**
     * RSA2 验签。
     *
     * 公开公钥为空时直接判定失败，避免"未配置即放行"的越权风险。
     *
     * @param signContent 参与签名的内容（POST/PUT 为原始请求体，GET/DELETE 为排序拼接后的查询参数）
     * @param sign        请求头 sign 携带的 Base64 签名值
     * @param publicKey   开发者公钥（Base64 编码的 X.509）
     */
    private boolean verifySign(String signContent, String sign, String publicKey,
                               String token, String operatorAccount, String uniqueCode, String logContent) {
        if (MyStringUtils.isBlank(publicKey)) {
            throw new RequestParamsException(token, operatorAccount, uniqueCode, logContent,
                    ApiCode.DATA_CHECK_ERROR, "开发者未配置验签公钥");
        }
        if (MyStringUtils.isBlank(sign)) {
            throw new RequestParamsException(token, operatorAccount, uniqueCode, logContent,
                    ApiCode.DATA_CHECK_ERROR, "缺少签名(sign)");
        }
        try {
            boolean ok = ApiSignature.check(signContent, sign, publicKey,
                    ApiConstants.CHARSET_UTF8, ApiConstants.SIGN_TYPE_RSA2);
            if (!ok) {
                throw new RequestParamsException(token, operatorAccount, uniqueCode, logContent, ApiCode.DATA_CHECK_ERROR);
            }
            return true;
        } catch (RequestParamsException e) {
            throw e;
        } catch (Exception e) {
            log.warn("OpenAPI 验签异常: {}", e.getMessage());
            throw new RequestParamsException(token, operatorAccount, uniqueCode, logContent,
                    ApiCode.DATA_CHECK_ERROR, e.getMessage());
        }
    }

    /**
     * 校验时间戳与 nonce 是否携带且在允许的时间窗口内（±5 分钟，与回调 AOP 一致）。
     */
    private void validateTimestampAndNonce(String timestamp, String nonce) {
        if (MyStringUtils.isBlank(timestamp)) {
            throw new RequestParamsException(ApiCode.PARAM_MISSING, "缺少 timestamp 请求头");
        }
        if (MyStringUtils.isBlank(nonce)) {
            throw new RequestParamsException(ApiCode.PARAM_MISSING, "缺少 nonce 请求头");
        }
        long requestTime;
        try {
            requestTime = Long.parseLong(timestamp);
        } catch (NumberFormatException e) {
            throw new RequestParamsException(ApiCode.TIMESTAMP_INVALID);
        }
        if (Math.abs(System.currentTimeMillis() - requestTime) > 300000L) {
            throw new RequestParamsException(ApiCode.TIMESTAMP_INVALID);
        }
    }

    /**
     * 用 Redis SET NX 一次性消费 nonce，重复出现即判定为重放。
     */
    private void consumeNonce(String nonce) {
        Boolean first = redisTemplate.opsForValue()
                .setIfAbsent("kfq:openapi:nonce:" + nonce, "1", 5, TimeUnit.MINUTES);
        if (first == null || !first) {
            throw new RequestParamsException(ApiCode.NONCE_REPEAT);
        }
    }

    /**
     * 把 timestamp/nonce 追加到待签名内容，保证二者不可被篡改。
     */
    private String buildSignContent(String content, String timestamp, String nonce) {
        return content + "&timestamp=" + timestamp + "&nonce=" + nonce;
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        try (BufferedReader reader = request.getReader()) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    private String cleanData(String data) {
        // 处理数据，删除或替换换行符和转义符
        String cleanedData = data.replace("\n", "").replace("\r", ""); // 删除换行符
        cleanedData = cleanedData.replace("\\n", "\n").replace("\\r", "\r"); // 还原转义符
        if (cleanedData.length() > 1024) {
            cleanedData = cleanedData.substring(0, 1024);
        }
        return cleanedData;
    }
}
