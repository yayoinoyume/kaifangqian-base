/**
 * @description 开始activiti流程
 */
package com.kaifangqian.modules.opensign.service.cmd;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.opensign.enums.SignFinishTypeEnum;
import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandContext;
import com.kaifangqian.modules.opensign.service.flow.IFlowService;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.opensign.config.OpensignFlowIntiConfig;
import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.entity.SignRuTask;
import com.kaifangqian.modules.opensign.enums.TaskTypeEnum;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;
import com.kaifangqian.modules.opensign.service.ru.SignRuTaskService;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:55
 * @description: 开始activiti流程
 */
public class SignActivitiFlowCmd implements SignCommand<TaskCmdInfo> {

    @Override
    public TaskCmdInfo execute(SignCommandContext signCommandContext) {
        //校验是否需要开启流程
        SignRuService signRuService = signCommandContext.getSignRuService();
        SignRuTaskService signRuTaskService = signCommandContext.getSignRuTaskService();
        IFlowService flowService = signCommandContext.getFlowService();
        SignRu signRu = signRuService.getById(signCommandContext.getSignRuId());
        if (signRu == null) {
            throw new PaasException("流程实例不存在");
        }
        if (signRu.getBeforeSignApproveType() == 1) {
            //创建审批任务节点
            SignRuTask task = new SignRuTask();
            task.setSignRuId(signCommandContext.getSignRuId());
            task.setTaskType(TaskTypeEnum.B_SIGN_TASK.getCode());
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
        } else if (signRu.getBeforeSignApproveType() == 2) {
            //初始化内部审批任务--创建(当前场景下的)下一个内部审批节点，系统任务直接完成。
            flowService.computeInAndNextSignTask(null, signCommandContext.getSignRuId());
            //计算是否驱动下一个任务
            SignRuTask query = new SignRuTask();
            query.setSignRuId(signCommandContext.getSignRuId());
            query.setTaskStatus(1);
            List<SignRuTask> tasks = signRuTaskService.getByEntity(query);
            if (CollUtil.isEmpty(tasks) && (signRu.getAutoFinish() == null || signRu.getAutoFinish() == SignFinishTypeEnum.AUTO_FINISH.getCode())) {
                //签署完成后抄送
                if (signRu != null) {
                    if (signRu.getCcedOpportunityType() == 2) {
                        flowService.copyFlow(signCommandContext.getSignRuId(), 2);
                    }
                }
                String nextTaskType = OpensignFlowIntiConfig.taskMap.get(signCommandContext.getTaskType()).getNextTaskType();
                if (nextTaskType != null) {
                    TaskCmdInfo result = new TaskCmdInfo();
                    result.setTaskType(nextTaskType);
                    //todo 如果修改驱动逻辑需要修改该步骤
                    result.setOperate("finishFlow");
                    return result;
                }
            }

            return null;
        } else {
            throw new PaasException("发起前是否需要开启流程类型错误");
        }
    }
}