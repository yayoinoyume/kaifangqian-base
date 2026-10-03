/**
 * @description API正常回调服务类
 */
package com.kaifangqian.modules.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.constant.ApiConstants;
import com.kaifangqian.modules.api.entity.ApiNormalReq;
import com.kaifangqian.modules.api.mapper.ApiNormalReqMapper;
import com.kaifangqian.modules.api.service.IApiNormalReqService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
@Service
public class ApiNormalReqServiceImpl extends ServiceImpl<ApiNormalReqMapper, ApiNormalReq> implements IApiNormalReqService {

    @Override
    public void recordNormalReq(ApiNormalReq req) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        req.setToken(request.getAttribute(ApiConstants.APP_AUTH_TOKEN).toString());
        if (request.getAttribute(ApiConstants.OPERATOR_ACCOUNT) != null) {
            req.setOperatorAccount(request.getAttribute(ApiConstants.OPERATOR_ACCOUNT).toString());
        }
        req.setUniqueCode(request.getAttribute(ApiConstants.UNIQUE_CODE).toString());
        req.setReqUrl(request.getRequestURI().toString());
        req.setReqPara(request.getAttribute(ApiConstants.REQ_PARA).toString());
        req.setCreateTime(new Date());
        this.save(req);
    }

    @Override
    public void recordNormalRes(String res) {
        ApiNormalReq req = new ApiNormalReq();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        req.setResPara(res);
        req.setToken(request.getAttribute(ApiConstants.APP_AUTH_TOKEN).toString());
        req.setOperatorAccount(request.getAttribute(ApiConstants.OPERATOR_ACCOUNT).toString());
        req.setUniqueCode(request.getAttribute(ApiConstants.UNIQUE_CODE).toString());
        req.setReqUrl(request.getRequestURI().toString());
        req.setReqPara(request.getAttribute(ApiConstants.REQ_PARA).toString());
        req.setCreateTime(new Date());
        this.save(req);
    }
}
