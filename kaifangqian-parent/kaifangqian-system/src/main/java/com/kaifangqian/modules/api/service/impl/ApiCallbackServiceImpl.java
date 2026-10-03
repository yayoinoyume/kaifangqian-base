/**
 * @description API回调服务类
 */
package com.kaifangqian.modules.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.constant.ApiConstants;
import com.kaifangqian.modules.api.entity.ApiCallback;
import com.kaifangqian.modules.api.mapper.ApiCallbackMapper;
import com.kaifangqian.modules.api.service.IApiCallbackService;
import com.kaifangqian.modules.api.vo.request.ApiCallbackVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
@Service
public class ApiCallbackServiceImpl extends ServiceImpl<ApiCallbackMapper, ApiCallback> implements IApiCallbackService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @create by zhenghuihan
     * @createTime 2024/3/26 11:22
     * @description 新增消息
     */
    @Override
    public boolean addCallback(String url, String data) {
        //入库
        ApiCallback callback = new ApiCallback();
        callback.setCallbackUrl(url);
        callback.setReqPara(data);
        callback.setStatus(0);

        this.save(callback);
        ApiCallbackVO callbackVO = new ApiCallbackVO();
        BeanUtils.copyProperties(callback, callbackVO);
        //入队列
        redisTemplate.opsForList().leftPush(ApiConstants.API_QUEUE_KEY, callbackVO);
        return true;
    }

    @Override
    public List<ApiCallback> getByStatus(Integer status) {
        LambdaQueryWrapper<ApiCallback> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApiCallback::getStatus, status);

        return list(queryWrapper);
    }
}
