/**
 * @description 流程任务查询
 */
package com.kaifangqian.modules.opensign.service.flow;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.opensign.vo.request.ru.CompanyStasticsVO;
import com.kaifangqian.modules.opensign.vo.request.ru.MenuStasticsVO;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoReq;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoRes;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:11
 * @description: 流程任务查询
 */
public interface IInstanceTaskService {

    IPage<TaskListInfoRes> listInbox(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listSend(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listCopyMe(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listDraft(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listRecycle(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listCompanyAll(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listPersonalAll(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listMyJob(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listCompanyOtherJob(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listPersonalOtherJob(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listRunning(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listFinish(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listInvalid(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listMySignJob(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listMyApproveJob(Page<TaskListInfoRes> page, TaskListInfoReq req);

    IPage<TaskListInfoRes> listMyFillInJob(Page<TaskListInfoRes> page, TaskListInfoReq req);

    CompanyStasticsVO myStastics();

    MenuStasticsVO companyMenuStastics();

    MenuStasticsVO personalMenuStastics();

    /**
     * @param
     */
    Integer checkAuth(String taskId);

    void setParticipateNames(IPage<TaskListInfoRes> result);
}