package com.kaifangqian.modules.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.system.entity.SysAuthGroupPermission;
import com.kaifangqian.modules.system.vo.AppPermissionVO;
import com.kaifangqian.modules.system.vo.PermissionRuleVO;
import com.kaifangqian.modules.system.vo.SysAuthGroupPermissionReq;
import com.kaifangqian.annotation.ResrunLogMethod;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.enums.OperateLogType;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.system.service.ISysAuthGroupPermissionService;
import com.kaifangqian.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhenghuihan
 * @description 权限组-权限表
 * @createTime 2022/9/2 18:06
 */
// @Api(tags = "权限组-权限表")
@RestController
@RequestMapping("/system/sysAuthGroupPermission")
@Slf4j
@ResrunLogModule(name = "权限组权限管理模块")
public class SysAuthGroupPermissionController {
    @Autowired
    private ISysAuthGroupPermissionService sysAuthGroupPermissionService;

    /**
     * 查询
     *
     * @param sysAuthGroupPermission
     * @return
     */
    // @ApiOperation(value = "查询", notes = "查询")
    @GetMapping(value = "/list")
    @ResrunLogMethod(name = "查询权限组中的权限列表", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<?> queryPageList(SysAuthGroupPermission sysAuthGroupPermission) {
        if (MyStringUtils.isBlank(sysAuthGroupPermission.getGroupId())) {
            return Result.error("参数错误");
        } else {
            List<AppPermissionVO> result = new ArrayList<>();
            List<SysAuthGroupPermission> list = sysAuthGroupPermissionService.listByEntity(sysAuthGroupPermission);
            if (CollUtil.isNotEmpty(list)) {
                Map<String, List<SysAuthGroupPermission>> appMap = list.stream().collect(Collectors.groupingBy(SysAuthGroupPermission::getAppId));
                if (CollUtil.isNotEmpty(appMap)) {
                    for (Map.Entry<String, List<SysAuthGroupPermission>> entry1 : appMap.entrySet()) {
                        AppPermissionVO appPermissionVO = new AppPermissionVO();
                        appPermissionVO.setAppId(entry1.getKey());
                        List<PermissionRuleVO> ruleVOS = new ArrayList<>();
                        if (CollUtil.isNotEmpty(entry1.getValue())) {
                            Map<String, List<SysAuthGroupPermission>> map = entry1.getValue().stream().collect(Collectors.groupingBy(SysAuthGroupPermission::getPermissionId));
                            for (Map.Entry<String, List<SysAuthGroupPermission>> entry2 : map.entrySet()) {
                                PermissionRuleVO vo = new PermissionRuleVO();
                                vo.setPermissionId(entry2.getKey());
                                List<SysAuthGroupPermission> val = entry2.getValue();
                                if (CollUtil.isNotEmpty(val)) {
                                    vo.setRuleIds(val.stream().map(SysAuthGroupPermission::getPermissionDataId).collect(Collectors.toList()));
                                }
                                ruleVOS.add(vo);
                            }
                        }
                        appPermissionVO.setRuleVOS(ruleVOS);
                        result.add(appPermissionVO);
                    }
                }
            }
            return Result.OK(result);
        }
    }

    /**
     * 编辑
     *
     * @param req
     * @return
     */
    // @ApiOperation(value = "权限组-权限表-编辑", notes = "权限组-权限表-编辑")
    @PostMapping(value = "/edit")
    @ResrunLogMethod(name = "编辑权限组中的权限", operateType = OperateLogType.OPERATE_TYPE_3)
    public Result<?> edit(@RequestBody SysAuthGroupPermissionReq req) {
        sysAuthGroupPermissionService.editExt(req);
        return Result.OK("编辑成功!");
    }
}
