/**
 * @description 文档签署截止时间定时任务
 */
package com.kaifangqian.modules.opensign.task;

import com.kaifangqian.modules.opensign.service.ru.SignRuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.log.OmsLogger;

/**
 * @author : zhenghuihan
 * create at:  2022/8/24  17:02
 * @description: 文档失效
 */
@Component
@Slf4j
public class SignRuProcessor implements tech.powerjob.worker.core.processor.sdk.BasicProcessor {

    @Autowired
    private SignRuService signRuService;

    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("文档失效定时任务开始");
        signRuService.updateStatus();
        return new ProcessResult(true, "文档失效定时任务结束");
    }
}