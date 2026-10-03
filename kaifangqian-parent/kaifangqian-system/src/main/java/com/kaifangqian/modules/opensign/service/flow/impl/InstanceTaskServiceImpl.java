/**
 * @description 流程任务查询实现类
 */
package com.kaifangqian.modules.opensign.service.flow.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.opensign.entity.SignRuSender;
import com.kaifangqian.modules.opensign.enums.*;
import com.kaifangqian.modules.opensign.service.flow.IInstanceTaskService;
import com.kaifangqian.modules.opensign.service.ru.SignRuSenderService;
import com.kaifangqian.modules.system.entity.SysTenantInfo;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.opensign.entity.SignRuSigner;
import com.kaifangqian.modules.opensign.entity.SignRuTask;
import com.kaifangqian.modules.opensign.mapper.SignRuTaskMapper;
import com.kaifangqian.modules.opensign.service.re.SignReAuthService;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;
import com.kaifangqian.modules.opensign.service.ru.SignRuSignerService;
import com.kaifangqian.modules.opensign.service.ru.SignRuTaskService;
import com.kaifangqian.modules.opensign.vo.request.ru.CompanyStasticsVO;
import com.kaifangqian.modules.opensign.vo.request.ru.MenuStasticsVO;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoReq;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoRes;
import com.kaifangqian.modules.system.service.ISysTenantInfoService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:11
 * @description: 流程任务查询
 */
@Service
public class InstanceTaskServiceImpl implements IInstanceTaskService {

    @Resource
    private SignRuTaskMapper mapper;
    @Autowired
    private SignReAuthService signReAuthService;
    @Autowired
    private SignRuService signRuService;
    @Autowired
    private SignRuTaskService signRuTaskService;
    @Autowired
    private ISysTenantInfoService sysTenantInfoService;
    @Autowired
    private SignRuSignerService signRuSignerService;
    @Autowired
    private SignRuSenderService signRuSenderService;


    @Override
    public IPage<TaskListInfoRes> listInbox(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listInbox(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listSend(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listSend(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listCopyMe(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listCopyMe(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listDraft(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listDraft(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listRecycle(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listRecycle(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listCompanyAll(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setSignReIds(signReAuthService.getMyViewSignRe());
        return mapper.listCompanyAll(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listPersonalAll(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listPersonalAll(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listMyJob(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listMyJob(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listCompanyOtherJob(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listCompanyOtherJob(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listPersonalOtherJob(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        return mapper.listPersonalOtherJob(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listRunning(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        if (req.isSignReFlag()) {
            req.setSignReIds(signReAuthService.getMyViewSignRe());
        }
        return mapper.listRunning(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listFinish(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setSignReIds(signReAuthService.getMyViewSignRe());
        return mapper.listFinish(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listInvalid(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setSignReIds(signReAuthService.getMyViewSignRe());
        return mapper.listInvalid(page, req);
    }

    @Override
    public IPage<TaskListInfoRes> listMySignJob(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setStatus(7);
        req.setTaskType(TaskTypeEnum.SIGN_TASK.getCode());
        IPage<TaskListInfoRes> result = mapper.listMyJobSignUsers(page, req);
        return result;
    }

    @Override
    public IPage<TaskListInfoRes> listMyApproveJob(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setStatus(7);
        req.setTaskType(TaskTypeEnum.APPROVE_TASK.getCode());
        IPage<TaskListInfoRes> result = mapper.listMyJobApproveUsers(page, req);
        return result;
    }

    @Override
    public IPage<TaskListInfoRes> listMyFillInJob(Page<TaskListInfoRes> page, TaskListInfoReq req) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setStatus(5);
        IPage<TaskListInfoRes> result = mapper.listMyJobSignUsers(page, req);
        return result;
    }

    @Override
    public CompanyStasticsVO myStastics() {
        CompanyStasticsVO result = new CompanyStasticsVO();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        result.setStatusCount(signRuService.countMyByStatus(null, list));
        result.setStatus6Count(signRuService.countMyByStatus(6, null));
        result.setStatus8Count(signRuService.countMyByStatus(8, null));
        result.setStatus9Count(signRuService.countMyByStatus(9, null));
        result.setStatus10Count(signRuService.countMyByStatus(10, null));
        result.setStatus11Count(signRuService.countMyByStatus(11, null));
        return result;
    }

    @Override
    public MenuStasticsVO companyMenuStastics() {
        MenuStasticsVO result = new MenuStasticsVO();
        Page page = new Page<>(1, 10);
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        TaskListInfoReq req = new TaskListInfoReq();
        req.setTenantUserId(loginUser.getTenantUserId());

        SysTenantInfo sysTenantInfo = sysTenantInfoService.getById(loginUser.getTenantId());
        if (sysTenantInfo != null && sysTenantInfo.getTenantType() == 1) {
            result.setMyCount(mapper.listMyJob(page, req).getTotal());
            result.setOtherCount(mapper.listCompanyOtherJob(page, req).getTotal());

            req.setSignReIds(signReAuthService.getMyViewSignRe());
            result.setAllCount(mapper.listCompanyAll(page, req).getTotal());
            result.setRunningCount(mapper.listRunning(page, req).getTotal());
            result.setFinishCount(mapper.listFinish(page, req).getTotal());
            result.setInvalidCount(mapper.listInvalid(page, req).getTotal());
        } else {
            result.setAllCount(mapper.listPersonalAll(page, req).getTotal());
            result.setMyCount(mapper.listMyJob(page, req).getTotal());
            result.setOtherCount(mapper.listPersonalOtherJob(page, req).getTotal());

            req.setSignReIds(signReAuthService.getMyViewSignRe());
            result.setRunningCount(mapper.listRunning(page, req).getTotal());
            result.setFinishCount(mapper.listFinish(page, req).getTotal());
            result.setInvalidCount(mapper.listInvalid(page, req).getTotal());
        }

        return result;
    }

    @Override
    public MenuStasticsVO personalMenuStastics() {
        MenuStasticsVO result = new MenuStasticsVO();
        Page page = new Page<>(1, 10);
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        TaskListInfoReq req = new TaskListInfoReq();
        req.setTenantUserId(loginUser.getTenantUserId());
        req.setSignReIds(signReAuthService.getMyViewSignRe());
        SysTenantInfo sysTenantInfo = sysTenantInfoService.getById(loginUser.getTenantId());
        if (sysTenantInfo != null && sysTenantInfo.getTenantType() == 1) {
            result.setAllCount(mapper.listCompanyAll(page, req).getTotal());
            result.setMyCount(mapper.listMyJob(page, req).getTotal());
            result.setOtherCount(mapper.listCompanyOtherJob(page, req).getTotal());
            result.setRunningCount(mapper.listRunning(page, req).getTotal());
            result.setFinishCount(mapper.listFinish(page, req).getTotal());
            result.setInvalidCount(mapper.listInvalid(page, req).getTotal());
        } else {
            result.setAllCount(mapper.listPersonalAll(page, req).getTotal());
            result.setMyCount(mapper.listMyJob(page, req).getTotal());
            result.setOtherCount(mapper.listPersonalOtherJob(page, req).getTotal());
            result.setRunningCount(mapper.listRunning(page, req).getTotal());
            result.setFinishCount(mapper.listFinish(page, req).getTotal());
            result.setInvalidCount(mapper.listInvalid(page, req).getTotal());
        }

        return result;
    }

    @Override
    public Integer checkAuth(String taskId) {
        if (MyStringUtils.isBlank(taskId)) {
            throw new PaasException("参数异常");
        }
        SignRuTask signRuTask = signRuTaskService.getById(taskId);
        if (signRuTask != null) {
            LoginUser loginUser = MySecurityUtils.getCurrentUser();
            if (MyStringUtils.isBlank(signRuTask.getUserId())) {
                return SignAuthCheckEnum.AUTH3.getCode();
            }
            if (!signRuTask.getUserId().equals(loginUser.getId())) {
                return SignAuthCheckEnum.AUTH2.getCode();
            }
            if (MyStringUtils.isBlank(signRuTask.getTenantId())) {
                if (signRuTask.getUserType() == 2) {
                    return SignAuthCheckEnum.AUTH5.getCode();
                } else if (signRuTask.getUserType() == 1 || signRuTask.getUserType() == 3) {
                    return SignAuthCheckEnum.AUTH8.getCode();
                }
            }
            if (MyStringUtils.isBlank(signRuTask.getTenantUserId())) {
                return SignAuthCheckEnum.AUTH6.getCode();
            }
            if (!signRuTask.getTenantUserId().equals(loginUser.getTenantUserId())) {
                if (signRuTask.getUserType() == 2) {
                    return SignAuthCheckEnum.AUTH4.getCode();
                } else if (signRuTask.getUserType() == 1 || signRuTask.getUserType() == 3) {
                    return SignAuthCheckEnum.AUTH7.getCode();
                }
            }
            return SignAuthCheckEnum.AUTH1.getCode();
        }
        throw new PaasException("参数异常");
    }

    @Override
    public void setParticipateNames(IPage<TaskListInfoRes> result) {
        if (result != null) {
            List<TaskListInfoRes> list = result.getRecords();
            if (CollUtil.isNotEmpty(list)) {
                List<String> ruIds = list.stream().map(TaskListInfoRes::getSignRuId).collect(Collectors.toList());
                if (CollUtil.isNotEmpty(ruIds)) {
                    List<SignRuSigner> ruSigners = signRuSignerService.listByRuIds(ruIds);

                    //判断发起人是否有签署人，无则在签署人姓名列表中删除发起人
                    for(int i = 0; i < ruSigners.size(); i++){
                        if (ruSigners.get(i).getSignerType() == SignerTypeEnum.SENDER.getCode()){
                            List<SignRuSender> ruSenders = signRuSenderService.listBySignerId(ruSigners.get(i).getId());
                            if (CollUtil.isEmpty(ruSenders)){
                                ruSigners.remove(i);
                            }
                        }
                    }

                    if (CollUtil.isNotEmpty(ruSigners)) {
                        //Map<String, String> ruMap = ruSigners.stream().filter(s -> MyStringUtils.isBlank(s.getSignerName()) || s.getSignerOrder() == null).sorted(Comparator.comparing(SignRuSigner::getSignerOrder)).collect(Collectors.toMap(SignRuSigner::getSignRuId, t -> t.getSignerName(), (k1, k2) -> k1 + "、" + k2));

                        Map<String, String> ruMap = ruSigners.stream().sorted(Comparator.comparing(SignRuSigner::getSignerOrder)).collect(Collectors.toMap(SignRuSigner::getSignRuId, t -> t.getSignerName(), (k1, k2) -> k1 + "、" + k2));
                        for (TaskListInfoRes res : list) {
                            res.setParticipateNames(ruMap.get(res.getSignRuId()));
                        }
                    }
                }
            }
        }
    }
}