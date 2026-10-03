package com.kaifangqian.modules.system.controller;

import com.kaifangqian.modules.system.entity.SysTextConfig;
import com.kaifangqian.annotation.ResrunLogMethod;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.enums.OperateLogType;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.system.service.ISysTextConfigService;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : zhenghuihan
 * create at:  2022/7/27  09:55
 * @description: 系统文本配置控制类
 */

// @Api(tags = "系统文本配置控制类")
@RestController
@RequestMapping("/sys/sysTextConfig")
@Slf4j
@ResrunLogModule(name = "系统文本配置控制类")
public class SysTextConfigController {

    @Autowired
    private ISysTextConfigService sysTextConfigService;

    @ResrunLogMethod(name = "查询系统配置信息-无token", operateType = OperateLogType.OPERATE_TYPE_1)
    // @ApiOperation(value = "获取配置信息-无token", notes = "获取配置信息-无token")
    @GetMapping("/info")
    public Result<?> getConfigNoToken(@RequestParam(name = "type", required = true) String type) {
        SysTextConfig sysTextConfig = sysTextConfigService.getByType(type);

        return Result.OK("ok", sysTextConfig.getValue());
    }

    @ResrunLogMethod(name = "查询系统配置信息", operateType = OperateLogType.OPERATE_TYPE_1)
    // @ApiOperation(value = "获取配置信息", notes = "获取配置信息")
    @GetMapping
    public Result<?> getConfig(@RequestParam(name = "type", required = true) String type) {
        SysTextConfig sysTextConfig = sysTextConfigService.getByType(type);
        return Result.OK(sysTextConfig);
    }

    @ResrunLogMethod(name = "更新系统配置信息", operateType = OperateLogType.OPERATE_TYPE_3)
    // @ApiOperation(value = "更新配置信息", notes = "更新配置信息")
    @PostMapping
    @RequiresPermissions("system:manage")
    public Result<?> update(@RequestBody SysTextConfig sysTextConfig) {
        sysTextConfigService.updateById(sysTextConfig);
        return Result.OK();
    }
}