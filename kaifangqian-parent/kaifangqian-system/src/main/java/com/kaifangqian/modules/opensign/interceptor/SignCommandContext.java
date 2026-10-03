/**
 * @description 签署节点业务相关信息
 */
package com.kaifangqian.modules.opensign.interceptor;

import com.kaifangqian.modules.opensign.service.business.RuSignFlowService;
import com.kaifangqian.modules.opensign.service.flow.IFlowService;
import com.kaifangqian.modules.opensign.service.ru.*;
import com.kaifangqian.modules.opensign.service.ru.*;
import com.kaifangqian.modules.system.service.ISysTenantUserService;
import com.kaifangqian.modules.system.service.ISysUserService;
import com.kaifangqian.utils.SysMessageUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SignCommandContext {
    //实例ID
    private String signRuId;
    //任务ID
    private String taskId;
    //任务类型
    private String taskType;
    //节点用户类型
    private Integer userType;
    //用户节点ID
    private String userTaskId;

    //流程实例主表
    @Autowired
    private SignRuService signRuService;
    //流程实例-任务节点表
    @Autowired
    private SignRuTaskService signRuTaskService;
    //流程实例-抄送人表
    @Autowired
    private SignRuCcerService signRuCcerService;
    //流程实例-操作表
    @Autowired
    private SignRuOperatorService signRuOperatorService;
    //流程实例-签署主表
    @Autowired
    private SignRuSignerService signRuSignerService;
    //流程实例-内部签署表
    @Autowired
    private SignRuSenderService signRuSenderService;
    @Autowired
    private SignRuRelationService signRuRelationService;
    @Autowired
    private ISysTenantUserService sysTenantUserService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IFlowService flowService;
    @Autowired
    private RuSignFlowService ruSignFlowService;
    @Autowired
    private SysMessageUtil sysMessageUtil;
}