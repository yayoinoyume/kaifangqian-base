package com.kaifangqian.modules.system.job;

import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.common.constant.CommonConstant;
import com.kaifangqian.modules.system.service.ISysUserService;
import com.kaifangqian.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

/**
 * @author : zhenghuihan
 * create at:  2022/9/5  16:25
 * @description: 修改用户信息job
 */
@Component
@Slf4j
public class BasicSysUserEditJob implements BasicProcessor {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        OmsLogger omsLogger = taskContext.getOmsLogger();
        omsLogger.info("BasicSysUserEditJob开始处理, 参数为 {}.", taskContext.getJobParams());

        if (MyStringUtils.isNotBlank(taskContext.getInstanceParams())) {
            SysUser sysUser = sysUserService.getUserByName(taskContext.getInstanceParams());
            if (sysUser != null && CommonConstant.USER_FREEZE_AUTO.equals(sysUser.getStatus())) {
                sysUser.setStatus(CommonConstant.USER_UNFREEZE);

                sysUserService.updateById(sysUser);
            }
        }

        return new ProcessResult(true, "任务处理成功");
    }

}