/**
 * @description 初始化填写节点
 */
package com.kaifangqian.modules.opensign.service.cmd;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandContext;
import com.kaifangqian.modules.opensign.service.flow.IFlowService;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.opensign.config.OpensignFlowIntiConfig;
import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.entity.SignRuOperator;
import com.kaifangqian.modules.opensign.enums.SignRuStatusEnum;
import com.kaifangqian.modules.opensign.service.ru.SignRuOperatorService;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:55
 * @description: 初始化填写节点
 */
public class InitiateFillInTaskCmd implements SignCommand<TaskCmdInfo> {

    @Override
    public TaskCmdInfo execute(SignCommandContext signCommandContext) {
        SignRuService signRuService = signCommandContext.getSignRuService();
        SignRuOperatorService signRuOperatorService = signCommandContext.getSignRuOperatorService();
        IFlowService flowService = signCommandContext.getFlowService();
        SignRuOperator query = new SignRuOperator();
        query.setSignRuId(signCommandContext.getSignRuId());
        query.setOperateType(1);
        query.setOperateStatus(1);
        query.setSignerType(1);
        List<SignRuOperator> list1 = signRuOperatorService.getByEntity(query);
        if (CollUtil.isNotEmpty(list1)) {
            //发起人任务特殊处理
            flowService.computeFillInTask(list1, 1, signCommandContext.getSignRuId());
        }
        query.setSignerType(null);
        List<Integer> signerTypes = new ArrayList<>();
        signerTypes.add(2);
        signerTypes.add(3);
        query.setSignerTypes(signerTypes);
        List<SignRuOperator> list2 = signRuOperatorService.getByEntity(query);
        if (CollUtil.isNotEmpty(list2)) {
            SignRu signRu = signRuService.getById(signCommandContext.getSignRuId());
            if (signRu.getSignOrderType() == 1) {
                List<SignRuOperator> newList = new ArrayList<>();
                newList.add(list2.get(0));
                flowService.computeFillInTask(newList, 2, signCommandContext.getSignRuId());
            } else if (signRu.getSignOrderType() == 2) {
                flowService.computeFillInTask(list2, 2, signCommandContext.getSignRuId());
            } else {
                throw new PaasException("签署顺序类型不支持");
            }
            //修改实例状态
            signRu.setStatus(SignRuStatusEnum.WRITING.getCode());
            signRuService.updateById(signRu);
            return null;
        } else {
            //无填写任务-开启下一个任务
            String nextTaskType = OpensignFlowIntiConfig.taskMap.get(signCommandContext.getTaskType()).getNextTaskType();
            TaskCmdInfo result = new TaskCmdInfo();
            result.setTaskType(nextTaskType);
            //todo 如果修改驱动逻辑需要修改该步骤
            result.setOperate("initiateSignTask");
            return result;
        }
    }
}