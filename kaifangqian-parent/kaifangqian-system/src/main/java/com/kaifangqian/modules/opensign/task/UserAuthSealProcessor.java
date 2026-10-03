/**
 * @description 签章授权定时任务
 */
package com.kaifangqian.modules.opensign.task;

import com.kaifangqian.modules.opensign.service.ru.UserSealAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.log.OmsLogger;


/**
 * @author : zhenghuihan
 * create at:  2022/8/24  17:02
 * @description: 腾讯云token刷新
 */
@Component
@Slf4j
public class UserAuthSealProcessor implements tech.powerjob.worker.core.processor.sdk.BasicProcessor {

    @Autowired
    private UserSealAuthService userSealAuthService;
    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("用户授权签章定时任务开始");
        userSealAuthService.refreshAuth();
        return new ProcessResult(true, "用户授权签章定时任务结束");
    }
}