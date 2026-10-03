/**
 * @description 个人签署文档列表，状态为：填写中、签署中、已撤回时调用
 */
package com.kaifangqian.modules.opensign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.annotation.ResrunLogMethod;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.enums.OperateLogType;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.opensign.service.flow.IInstanceTaskService;
import com.kaifangqian.modules.opensign.vo.request.ru.MenuStasticsVO;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoReq;
import com.kaifangqian.modules.opensign.vo.request.ru.TaskListInfoRes;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @create by zhenghuihan
 * @createTime 2023/11/23 16:54
 * @description 状态为：填写中、签署中、已撤回时调用
 */
@Slf4j
@RestController
@RequestMapping("/personal/task")
@ResrunLogModule(name = "个人文档列表")
// @Api(tags = "个人文档列表")
public class PersonalTaskController {

    @Autowired
    private IInstanceTaskService instanceTaskService;

    // @ApiOperation(value = "收件箱", notes = "收件箱")
    @GetMapping(value = "/listInbox")
    @ResrunLogMethod(name = "收件箱", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listInbox(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listInbox(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "抄送我的", notes = "抄送我的")
    @GetMapping(value = "/listCopyMe")
    @ResrunLogMethod(name = "抄送我的", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listCopyMe(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listCopyMe(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "全部文档", notes = "全部文档")
    @GetMapping(value = "/listAll")
    @ResrunLogMethod(name = "全部文档", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listAll(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listPersonalAll(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "待我处理", notes = "待我处理")
    @GetMapping(value = "/listMyJob")
    @ResrunLogMethod(name = "待我处理", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listMyJob(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listMyJob(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "待他人处理", notes = "待他人处理")
    @GetMapping(value = "/listOtherJob")
    @ResrunLogMethod(name = "待他人处理", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listPersonalOtherJob(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listPersonalOtherJob(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "未完成", notes = "未完成")
    @GetMapping(value = "/listRunning")
    @ResrunLogMethod(name = "未完成", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listRunning(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        req.setSignReFlag(false);
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listRunning(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "已完成", notes = "已完成")
    @GetMapping(value = "/listFinish")
    @ResrunLogMethod(name = "已完成", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listFinish(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        req.setSignReFlag(false);
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listFinish(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "已失效", notes = "已失效")
    @GetMapping(value = "/listInvalid")
    @ResrunLogMethod(name = "已失效", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<TaskListInfoRes>> listInvalid(TaskListInfoReq req, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        req.setSignReFlag(false);
        Page<TaskListInfoRes> page = new Page<TaskListInfoRes>(pageNo, pageSize);
        IPage<TaskListInfoRes> result = instanceTaskService.listInvalid(page, req);
        instanceTaskService.setParticipateNames(result);
        return Result.OK(result);
    }

    // @ApiOperation(value = "列表统计", notes = "列表统计")
    @GetMapping(value = "/menuStastics")
    @ResrunLogMethod(name = "列表统计", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<MenuStasticsVO> menuStastics() {
        MenuStasticsVO result = instanceTaskService.personalMenuStastics();

        return Result.OK(result);
    }
}