/**
 * @description API回调服务类
 */
package com.kaifangqian.modules.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.api.entity.ApiCallbackPageUrl;
import com.kaifangqian.modules.api.mapper.ApiCallbackPageUrlMapper;
import com.kaifangqian.modules.api.service.ApiCallbackPageUrlService;
import org.springframework.stereotype.Service;

/**
 * @Description: ApiCallbackPageUrlServiceImpl
 * @Package: com.kaifangqian.modules.api.service.impl
 * @ClassName: ApiCallbackPageUrlServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class ApiCallbackPageUrlServiceImpl extends ServiceImpl<ApiCallbackPageUrlMapper, ApiCallbackPageUrl> implements ApiCallbackPageUrlService {
}