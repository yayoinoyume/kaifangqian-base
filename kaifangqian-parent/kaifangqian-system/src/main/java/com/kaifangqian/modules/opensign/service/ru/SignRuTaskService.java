/**
 * @description 签署业务签署任务接口类，获取各类签署任务
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.vo.SysTenantInfoExtendVO;
import com.kaifangqian.modules.opensign.entity.SignRuTask;
import com.kaifangqian.modules.opensign.vo.base.sign.TaskInfoFor3rdVO;
import com.kaifangqian.modules.opensign.vo.base.sign.TaskSearchFor3rdVO;

import java.util.List;

public interface SignRuTaskService extends IService<SignRuTask> {

    List<SignRuTask> getByEntity(SignRuTask query);

    List<SignRuTask> getNoUserList(SignRuTask query);

    List<SignRuTask> getNoTenantUserList(SignRuTask query);

    List<SignRuTask> getTenantNoBindList(SignRuTask query);

    List<SignRuTask> getTenantNoBindListForApi(SignRuTask query);

    List<SignRuTask> getTenantNoBindListForLoading(SignRuTask query);

    List<SignRuTask> getPersonalTenanList(SignRuTask query);

    List<SysTenantInfoExtendVO> getMyTenantJobs();

    TaskInfoFor3rdVO getTaskInfoFor3rd(TaskSearchFor3rdVO searchFor3rdVO);

    String getCodeFor3rd(TaskSearchFor3rdVO searchFor3rdVO);
}