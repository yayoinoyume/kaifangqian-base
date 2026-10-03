/**
 * @description 开始activiti流程
 */
package com.kaifangqian.modules.opensign.service.cmd;

import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandContext;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.opensign.config.OpensignFlowIntiConfig;
import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.entity.SignRuTask;
import com.kaifangqian.modules.opensign.enums.SignRuStatusEnum;
import com.kaifangqian.modules.opensign.enums.TaskTypeEnum;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;
import com.kaifangqian.modules.opensign.service.ru.SignRuTaskService;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:55
 * @description: 开始activiti流程
 */
public class StartActivitiFlowCmd implements SignCommand<TaskCmdInfo> {

    @Override
    public TaskCmdInfo execute(SignCommandContext signCommandContext) {
        //校验是否需要开启流程
        SignRuService signRuService = signCommandContext.getSignRuService();
        SignRuTaskService signRuTaskService = signCommandContext.getSignRuTaskService();
        SignRu signRu = signRuService.getById(signCommandContext.getSignRuId());
        if (signRu == null) {
            throw new PaasException("流程实例不存在");
        }
        if (signRu.getBeforeStartApproveType() == 1) {
            //修改状态
            signRu.setStatus(SignRuStatusEnum.APPROVING.getCode());
            signRuService.updateById(signRu);

            //创建审批任务节点
            SignRuTask task = new SignRuTask();
            task.setSignRuId(signCommandContext.getSignRuId());
            task.setTaskType(TaskTypeEnum.B_START_TASK.getCode());
            task.setUserTaskId("system");
            task.setUserId("system");
            task.setTenantUserId("system");
            task.setTenantId("system");
            task.setTaskLinkType("system");
            task.setPhone("system");
            task.setEmail("system");
            task.setTaskLinkType("system");
            task.setTaskStatus(1);
            signRuTaskService.save(task);
            //todo 开启流程存入task的Id
            return null;
        } else if (signRu.getBeforeStartApproveType() == 2) {
            String nextTaskType = OpensignFlowIntiConfig.taskMap.get(signCommandContext.getTaskType()).getNextTaskType();
            TaskCmdInfo result = new TaskCmdInfo();
            result.setTaskType(nextTaskType);
            //todo 如果修改驱动逻辑需要修改该步骤
            result.setOperate("realStartFlow");
            return result;
        } else {

            throw new PaasException("发起前是否需要开启流程类型错误");
        }
    }
}