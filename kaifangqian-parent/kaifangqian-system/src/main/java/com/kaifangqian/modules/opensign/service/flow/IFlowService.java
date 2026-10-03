/**
 * @description 流程驱动服务接口类
 */
package com.kaifangqian.modules.opensign.service.flow;

import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRuOperator;
import com.kaifangqian.modules.opensign.entity.SignRuSigner;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:11
 * @description: 流程驱动服务接口类
 */
public interface IFlowService {
    /**
     * 驱动流程:instanceId:实例ID taskId:任务ID operate：操作
     */
    void complete(String instanceId, String operate);

    void computeFillInTask(List<SignRuOperator> list, Integer type, String signRuId);

    void addStartFlowTask(String signRuId);

    void computePersonalOutSignTask(List<SignRuSigner> signers, String signRuId);

    void computeCompanyOutSignTask(List<SignRuSigner> signers, String taskId, String signRuId) ;

    TaskCmdInfo computeCompanyOutAndNextSignTask(String taskId, String signRuId) ;

    TaskCmdInfo computeInAndNextSignTask(String taskId, String signRuId) ;

    void computeInSignTask(String taskId, String signRuId);

    /**
     * @description type:1 发起时，2 完成签署时
     */
    void copyFlow(String signRuId, Integer type);

    /**
     * 解析数据库已有数据做绑定表：sign_ru_task
     */
    void bindOutUserTask(String tenantName, String phone, String email, String fromTenantId, String fromUserId, String userId, String tenantId, String tenantUserId, String linkType);

    /**
     * 解析数据库已有数据做绑定表：sign_ru_task
     */
    void bindOutUserTaskAll(String phone, String email, String linkType);

    /**
     * 解析数据库已有数据做绑定表：sign_ru_task
     */
    void bindTenantUserTaskAll(String tenantId, String linkType);

    /**
     * 解析数据库已有数据做绑定表：sign_ru_relation
     */
    void bindOutUserRelation(String phone, String email, String tenantUserId, String linkType);

    void signReportAndSave(String ruId);
}