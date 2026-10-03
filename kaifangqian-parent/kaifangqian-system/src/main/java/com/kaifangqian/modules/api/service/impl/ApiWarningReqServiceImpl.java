/**
 * @description API警告服务类
 */
package com.kaifangqian.modules.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.api.entity.ApiWarningReq;
import com.kaifangqian.modules.api.mapper.ApiWarningReqMapper;
import com.kaifangqian.modules.api.service.IApiWarningReqService;
import com.kaifangqian.utils.IPUtil;
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
public class ApiWarningReqServiceImpl extends ServiceImpl<ApiWarningReqMapper, ApiWarningReq> implements IApiWarningReqService {

    @Override
    public void recordWarningReq(ApiWarningReq req) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        req.setReqIp(IPUtil.getIp(request));
        req.setCreateTime(new Date());
        this.save(req);
    }
}
