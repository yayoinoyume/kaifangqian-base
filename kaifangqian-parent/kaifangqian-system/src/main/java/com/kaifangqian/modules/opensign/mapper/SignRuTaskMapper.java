/**
 * @description 业务线实例-任务表Mapper
 */
package com.kaifangqian.modules.opensign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.vo.SysTenantInfoExtendVO;
import com.kaifangqian.modules.opensign.entity.SignRuTask;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoReq;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignRuTaskMapper extends BaseMapper<SignRuTask> {

    IPage<TaskListInfoRes> listInbox(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listSend(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listCopyMe(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listDraft(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listRecycle(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listCompanyAll(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listPersonalAll(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listMyJob(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listMyJobSignUsers(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listMyJobApproveUsers(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listCompanyOtherJob(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listPersonalOtherJob(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listRunning(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listFinish(Page page, @Param("req") TaskListInfoReq req);

    IPage<TaskListInfoRes> listInvalid(Page page, @Param("req") TaskListInfoReq req);

    List<SysTenantInfoExtendVO> getMyTenantJobs(@Param("userId") String userId);
}