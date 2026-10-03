package com.kaifangqian.modules.system.job;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.system.entity.SysAnnouncement;
import com.kaifangqian.common.constant.CommonConstant;
import com.kaifangqian.modules.system.service.ISysAnnouncementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

import java.util.Date;
import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/8/24  17:02
 * @description: 公告发布撤销处理-单机任务
 */
@Component
@Slf4j
public class AnnoncementProcessor implements BasicProcessor {

    @Autowired
    private ISysAnnouncementService sysAnnouncementService;

    @Override
    public ProcessResult process(TaskContext context) throws Exception {

        // 在线日志功能
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("公告定时任务开始处理");

        List<SysAnnouncement> list1 = sysAnnouncementService.getJobPublishedList();
        omsLogger.info("更细过时公告为撤销状态");
        if (CollUtil.isNotEmpty(list1)) {
            list1.forEach(a -> {
                a.setSendStatus(CommonConstant.REVOKE_STATUS_3);
                a.setSendTime(new Date());
            });
            sysAnnouncementService.updateBatchById(list1);
        }

        List<SysAnnouncement> list2 = sysAnnouncementService.getJobPublishingList();
        omsLogger.info("更新发布中公告为已发布状态");
        if (CollUtil.isNotEmpty(list2)) {
            list2.forEach(a -> {
                a.setSendStatus(CommonConstant.PUBLISHED_STATUS_2);
                a.setSendTime(new Date());
            });
            sysAnnouncementService.updateBatchById(list2);
        }

        return new ProcessResult(true, "success");
    }
}