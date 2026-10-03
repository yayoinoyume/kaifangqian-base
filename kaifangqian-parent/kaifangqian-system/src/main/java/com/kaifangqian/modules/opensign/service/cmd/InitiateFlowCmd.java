/**
 * @description 发起、初始化流程命令
 */
package com.kaifangqian.modules.opensign.service.cmd;

import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandContext;
import com.kaifangqian.modules.opensign.config.OpensignFlowIntiConfig;
import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;

import java.util.Date;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:55
 * @description: 发起、初始化流程命令
 */
public class InitiateFlowCmd implements SignCommand<TaskCmdInfo> {

    @Override
    public TaskCmdInfo execute(SignCommandContext signCommandContext) {
        SignRuService signRuService = signCommandContext.getSignRuService();
        SignRu signRu = signRuService.getById(signCommandContext.getSignRuId());
        //设置发起时间
        signRu.setStartTime(new Date());
        signRuService.updateById(signRu);
        String nextTaskType = OpensignFlowIntiConfig.taskMap.get(signCommandContext.getTaskType()).getNextTaskType();
        if (nextTaskType != null) {
            TaskCmdInfo result = new TaskCmdInfo();
            result.setTaskType(nextTaskType);
            //todo 如果修改驱动逻辑需要修改该步骤
            result.setOperate("startActivitiFlow");
            return result;
        } else {

            return null;
        }
    }
}