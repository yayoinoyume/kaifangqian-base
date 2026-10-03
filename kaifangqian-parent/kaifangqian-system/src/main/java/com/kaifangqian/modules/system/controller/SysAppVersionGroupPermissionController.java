package com.kaifangqian.modules.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.system.entity.SysAppVersionGroupPermission;
import com.kaifangqian.modules.system.vo.PermissionRuleVO;
import com.kaifangqian.modules.system.vo.SysAppVersionGroupPermissionReq;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.system.service.ISysAppVersionGroupPermissionService;
import com.kaifangqian.modules.system.vo.*;
import com.kaifangqian.utils.MyStringUtils;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// @Api(tags = "应用权限组权限表")
@RestController
@RequestMapping("/system/SysAppVersionGroupPermission")
@Slf4j
public class SysAppVersionGroupPermissionController {

    @Autowired
    private ISysAppVersionGroupPermissionService iSysAppVersionGroupPermissionService;

    /**
     * 查询
     *
     * @param sysAppVersionGroupPermission
     * @return
     */
    // @ApiOperation(value = "查询", notes = "查询")
    @GetMapping(value = "/list")
    @RequiresPermissions("system:develop")
    public Result<?> queryPageList(SysAppVersionGroupPermission sysAppVersionGroupPermission) {
        if (MyStringUtils.isBlank(sysAppVersionGroupPermission.getGroupId())) {
            return Result.error("参数错误");
        } else {
            SysAppVersionGroupPermissionReq result = new SysAppVersionGroupPermissionReq();
            List<SysAppVersionGroupPermission> list = iSysAppVersionGroupPermissionService.listByEntity(sysAppVersionGroupPermission);
            result.setGroupId(sysAppVersionGroupPermission.getGroupId());
            if (CollUtil.isNotEmpty(list)) {
                List<PermissionRuleVO> ruleVOS = new ArrayList<>();
                Map<String, List<SysAppVersionGroupPermission>> map = list.stream().collect(Collectors.groupingBy(SysAppVersionGroupPermission::getPermissionId));
                for (Map.Entry<String, List<SysAppVersionGroupPermission>> entry : map.entrySet()) {
                    PermissionRuleVO vo = new PermissionRuleVO();
                    vo.setPermissionId(entry.getKey());
                    List<SysAppVersionGroupPermission> val = entry.getValue();
                    if (CollUtil.isNotEmpty(val)) {
                        vo.setRuleIds(val.stream().map(SysAppVersionGroupPermission::getPermissionDataId).collect(Collectors.toList()));
                    }

                    ruleVOS.add(vo);
                }
                result.setRuleVOS(ruleVOS);
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
    @RequiresPermissions("system:develop")
    public Result<?> edit(@RequestBody SysAppVersionGroupPermissionReq req) {
        iSysAppVersionGroupPermissionService.editExt(req);
        return Result.OK("编辑成功!");
    }
}
