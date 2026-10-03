/**
 * @description 真正发起流程命令
 */
package com.kaifangqian.modules.opensign.service.cmd;

import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandContext;
import com.kaifangqian.modules.opensign.service.flow.IFlowService;
import com.kaifangqian.modules.opensign.config.OpensignFlowIntiConfig;
import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.enums.SignRuStatusEnum;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:55
 * @description: 真正发起流程命令
 */
public class RealStartFlowCmd implements SignCommand<TaskCmdInfo> {

    @Override
    public TaskCmdInfo execute(SignCommandContext signCommandContext) {
        SignRuService signRuService = signCommandContext.getSignRuService();
        IFlowService flowService = signCommandContext.getFlowService();
        SignRu signRu = signRuService.getById(signCommandContext.getSignRuId());
        //修改状态
        signRu.setStatus(SignRuStatusEnum.START.getCode());
        signRuService.updateById(signRu);
        //发起人创建发起任务节点
        flowService.addStartFlowTask(signCommandContext.getSignRuId());
        //文件发起后抄送
        if (signRu != null) {
            if (signRu.getCcedOpportunityType() == 1) {
                signCommandContext.getFlowService().copyFlow(signCommandContext.getSignRuId(),1);
            }
        }
        String nextTaskType = OpensignFlowIntiConfig.taskMap.get(signCommandContext.getTaskType()).getNextTaskType();
        if (nextTaskType != null) {
            TaskCmdInfo result = new TaskCmdInfo();
            result.setTaskType(nextTaskType);
            //todo 如果修改驱动逻辑需要修改该步骤
            result.setOperate("initiateFillInTask");
            return result;
        } else {

            return null;
        }
    }
}