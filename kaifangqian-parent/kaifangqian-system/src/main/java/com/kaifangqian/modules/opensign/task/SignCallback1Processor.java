/**
 * @description API接口签署回调服务
 */
package com.kaifangqian.modules.opensign.task;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.api.entity.ApiCallback;
import com.kaifangqian.modules.api.service.IApiCallbackService;
import com.kaifangqian.modules.api.vo.request.ApiCallbackVO;
import com.kaifangqian.common.constant.ApiConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.log.OmsLogger;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/8/24  17:02
 * @description: 回调1任务
 */
@Component
@Slf4j
public class SignCallback1Processor implements tech.powerjob.worker.core.processor.sdk.BasicProcessor {

    @Autowired
    private IApiCallbackService apiCallbackService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("回调定时任务开始");
        List<ApiCallback> list = apiCallbackService.getByStatus(1);
        if (CollUtil.isNotEmpty(list)) {
            list.forEach(l -> {
                ApiCallbackVO callbackVO = new ApiCallbackVO();
                BeanUtils.copyProperties(l, callbackVO);
                //入队列
                redisTemplate.opsForList().leftPush(ApiConstants.API_QUEUE_KEY, callbackVO);
            });
        }
        return new ProcessResult(true, "回调定时任务开始");
    }
}