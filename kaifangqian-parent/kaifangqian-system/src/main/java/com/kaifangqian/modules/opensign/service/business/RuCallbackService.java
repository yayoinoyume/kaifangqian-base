/**
 * @description 签署回调业务
 */
package com.kaifangqian.modules.opensign.service.business;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaifangqian.modules.api.service.IApiCallbackService;
import com.kaifangqian.modules.api.vo.base.ContractUser;
import com.kaifangqian.modules.opensign.enums.*;
import com.kaifangqian.modules.opensign.service.business.vo.SignCallbackVo;
import com.kaifangqian.modules.opensign.service.ru.*;
import com.kaifangqian.modules.system.entity.ApiDeveloperManage;
import com.kaifangqian.modules.system.entity.SysTenantInfo;
import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.entity.SignRuOperateRecord;
import com.kaifangqian.modules.opensign.entity.SignRuSender;
import com.kaifangqian.modules.opensign.entity.SignRuTask;
import com.kaifangqian.modules.opensign.enums.*;
import com.kaifangqian.modules.opensign.service.ru.*;
import com.kaifangqian.modules.system.service.IApiDeveloperManageService;
import com.kaifangqian.modules.system.service.ISysTenantInfoService;
import com.kaifangqian.modules.system.service.ISysUserService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 回调业务
 * @Package: com.kaifangqian.modules.opensign.service.business
 * @ClassName: RuCallbackService
 * @author: FengLai_Gong
 */
@Service
public class RuCallbackService {

    @Autowired
    private IApiDeveloperManageService apiDeveloperManageService ;
    @Autowired
    private IApiCallbackService apiCallbackService ;
    @Autowired
    private SignRuTaskService ruTaskService ;
    @Autowired
    private SignRuService ruService ;
    @Autowired
    private SignRuSignerService ruSignerService ;
    @Autowired
    private SignRuSenderService ruSenderService ;

    @Autowired
    private ISysTenantInfoService tenantInfoService ;
    @Autowired
    private ISysUserService userService ;
    @Autowired
    private SignRuOperateRecordService signRuOperateRecordService ;



    /**
     * @Description #统一回调方法
     * @Param [tenantId, ruId, taskId, signCallbackTypeEnum]
     * @return void
     **/
    public void callback(String ruId, String taskId, SignCallbackTypeEnum signCallbackTypeEnum){

        //创建回调对象
        SignCallbackVo callbackVo = new SignCallbackVo();
        SignRu signRu = ruService.getById(ruId);
        if(signRu == null){
            throw new PaasException("合同不存在");
        }
        SignRuStatusEnum signRuStatusEnum = SignRuStatusEnum.getByCode(signRu.getStatus());
        if(signRuStatusEnum == null){
            throw new PaasException("合同状态异常");
        }
        String callbackUrl = getCallbackUrl(signRu.getSysTenantId());
        if(callbackUrl == null || callbackUrl.length() == 0){
            //如果回调地址没有，则直接结束
            return;
        }


        //通用参数
        callbackVo.setContractStatus(signRuStatusEnum.getType());
        callbackVo.setContractId(signRu.getId());
        callbackVo.setCallbackType(signCallbackTypeEnum.getType());
        callbackVo.setTaskId(taskId);

        //填写或签署操作
        if(!SignCallbackTypeEnum.getNormalList().contains(signCallbackTypeEnum.getType())){
            //正常操作
            SignRuTask ruTask = ruTaskService.getById(taskId);
            if(ruTask == null){
                throw new PaasException("合同任务不存在");
            }
            if(ruTask.getUserId() != null && !ruTask.getUserId().equals("system") && !ruTask.getUserId().equals("unknown")){
                //不是自动签署
                SysUser user = userService.getById(ruTask.getUserId());
                SysTenantInfo tenantInfo = tenantInfoService.getPersonalByTenantUserId(user.getId());
                if(user == null){
                    throw new PaasException("账号不存在");
                }
                //办理人
                ContractUser signer = new ContractUser();
                if (tenantInfo != null && MyStringUtils.isNotBlank(tenantInfo.getTenantName())){
                    signer.setName(tenantInfo.getTenantName());
                }else {
                    signer.setName(user.getUsername());
                }

                signer.setContact(user.getPhone());
                signer.setContactType("MOBILE");
                callbackVo.setSigner(signer);
            }

            //签署方类型
            Integer userType = ruTask.getUserType();
            String signerType = null ;
            if(userType == SignerTypeEnum.SENDER.getCode() || userType == SignerTypeEnum.RECEIVER_ENT.getCode()){
                signerType = "ENTERPRISE";
                SysTenantInfo tenantInfo = null ;
                if((ruTask.getCompleteTenantId() != null || ruTask.getTenantId() != null)
                        && !ruTask.getUserId().equals("system") && !ruTask.getUserId().equals("unknown")){
                    if(ruTask.getCompleteTenantId() != null){
                        tenantInfo = tenantInfoService.getById(ruTask.getCompleteTenantId());
                    }else if(ruTask.getTenantId() != null){
                        tenantInfo = tenantInfoService.getById(ruTask.getTenantId());
                    }
                }else {
                    tenantInfo = tenantInfoService.getById(signRu.getSysTenantId());
                }
                if(tenantInfo == null){
                    throw new PaasException("租户不存在");
                }
                callbackVo.setSignerName(tenantInfo.getTenantName());
            }else if(userType == SignerTypeEnum.RECEIVER_PERSONAL.getCode()){
                signerType = "PERSONAL";
            }
            callbackVo.setSignerType(signerType);

            if(SignCallbackTypeEnum.getSignList().contains(signCallbackTypeEnum.getType())){
                //签署、拒签、签署失败时返回内部节点
                if(signerType.equals("ENTERPRISE")){
                    SignRuSender ruSender = ruSenderService.getById(ruTask.getUserTaskId());
                    if(ruSender == null){
                        throw new PaasException("签署节点不存在");
                    }
                    String nodeType = null ;
                    if(ruSender.getSenderType() == SenderTypeEnum.OPERATOR.getCode()){
                        nodeType = "AGENT_SIGN";
                    }else if(ruSender.getSenderType() == SenderTypeEnum.LEGAL_PERSON.getCode()){
                        nodeType = "LEGAL_PERSON_SIGN";
                    }else if(ruSender.getSenderType() == SenderTypeEnum.PERSONAL.getCode()){
                        nodeType = "PERSONAL_SIGN";
                    }else if(ruSender.getSenderType() == SenderTypeEnum.ENTERPRISE.getCode()){
                        nodeType = "ENTERPRISE_SEAL";
                    }else if(ruSender.getSenderType() == SenderTypeEnum.APPROVER.getCode()){
                        nodeType = "APPROVER_CHECK";
                    }
                    callbackVo.setNodeType(nodeType);
                }
            }
        }
        //拒绝填写，拒绝签署，撤销合同的原因
        if(signCallbackTypeEnum.getType() == SignCallbackTypeEnum.REFUSAL_WRITE.getType() ||
                signCallbackTypeEnum.getType() == SignCallbackTypeEnum.REFUSAL_SIGN.getType()
                || signCallbackTypeEnum.getType() == SignCallbackTypeEnum.RECALLED.getType()){
            List<String> actionTypeList = new ArrayList<>();
            actionTypeList.add(SignRecordActionTypeEnum.REJECT_WRITE.getType());
            actionTypeList.add(SignRecordActionTypeEnum.REJECT_SIGN.getType());
            actionTypeList.add(SignRecordActionTypeEnum.REVOKE.getType());
            List<SignRuOperateRecord> recordList = signRuOperateRecordService.listByActionList(ruId, actionTypeList);
            if(recordList != null && recordList.size() > 0){
                SignRuOperateRecord ruOperateRecord = recordList.get(0);
                callbackVo.setReason(ruOperateRecord.getOperateReason());
            }
        }
        //回调
        apiCallbackService.addCallback(callbackUrl, JSON.toJSONString(callbackVo));
    }



    /**
     * @Description #获取回调地址
     * @Param [tenantId]
     * @return java.lang.String
     **/
    public String getCallbackUrl(String tenantId){
        QueryWrapper<ApiDeveloperManage> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ApiDeveloperManage::getTenantId,tenantId);
        wrapper.lambda().eq(ApiDeveloperManage::getStatus,1);
        List<ApiDeveloperManage> list = apiDeveloperManageService.list(wrapper);
        if(list != null && list.size() > 0){
            return list.get(0).getCallbackUrl();

        }
        return  null ;
    }















}