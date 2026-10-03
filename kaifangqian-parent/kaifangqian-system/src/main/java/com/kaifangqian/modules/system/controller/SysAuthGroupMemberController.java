package com.kaifangqian.modules.system.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysAuthGroupMember;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberList;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberList2;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberVO;
import com.kaifangqian.annotation.ResrunLogMethod;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.enums.OperateLogType;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.system.service.ISysAuthGroupMemberService;
import com.kaifangqian.modules.system.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;

/**
 * @author zhenghuihan
 * @description 权限组-成员表
 * @createTime 2022/9/2 18:06
 */
// @Api(tags = "权限组-成员表")
@RestController
@RequestMapping("/system/sysAuthGroupMember")
@Slf4j
@ResrunLogModule(name = "权限组成员管理模块")
public class SysAuthGroupMemberController {
    @Autowired
    private ISysAuthGroupMemberService sysAuthGroupMemberService;

    /**
     * 根据权限组id查询成员-分页列表查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    // @ApiOperation(value = "权限组-成员表-分页列表查询", notes = "权限组-成员表-分页列表查询")
    @GetMapping(value = "/list")
    @ResrunLogMethod(name = "根据权限组查询成员列表", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<SysAuthGroupMemberVO>> queryPageList(SysAuthGroupMember query, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SysAuthGroupMemberVO> page = new Page<SysAuthGroupMemberVO>(pageNo, pageSize);
        IPage<SysAuthGroupMemberVO> list = sysAuthGroupMemberService.pageList(page, query);
        return Result.OK(list);
    }

    /**
     * 根据权限id查询权限组-分页列表查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    // @ApiOperation(value = "根据权限id查询权限组-分页列表查询", notes = "根据权限id查询权限组-分页列表查询")
    @GetMapping(value = "/listByAuthId")
    @ResrunLogMethod(name = "根据成员查询权限组列表", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<IPage<SysAuthGroupMemberVO>> listByAuthId(SysAuthGroupMember query, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SysAuthGroupMemberVO> page = new Page<SysAuthGroupMemberVO>(pageNo, pageSize);
        IPage<SysAuthGroupMemberVO> list = sysAuthGroupMemberService.listByAuthId(page, query);
        return Result.OK(list);
    }

    /**
     * 添加
     *
     * @param memberList
     * @return
     */
    @RequiresPermissions(value = {"authgroup:addmember", "authgroup:addrole"}, logical = Logical.OR)
    // @ApiOperation(value = "权限组-多个成员-添加", notes = "权限组-多个成员-添加")
    @PostMapping(value = "/add")
    @ResrunLogMethod(name = "一个权限组增加多个成员", operateType = OperateLogType.OPERATE_TYPE_2)
    public Result<?> add(@RequestBody SysAuthGroupMemberList memberList) {
        sysAuthGroupMemberService.saveExt(memberList);
        return Result.OK("添加成功！");
    }

    /**
     * 添加
     *
     * @param memberList
     * @return
     */
    @RequiresPermissions(value = {"deptedit:authadd", "useredit:authadd", "roleedit:authadd"}, logical = Logical.OR)
    // @ApiOperation(value = "多个权限组-成员-添加", notes = "多个权限组-成员-添加")
    @PostMapping(value = "/addGroup")
    @ResrunLogMethod(name = "一个成员增加多个权限组", operateType = OperateLogType.OPERATE_TYPE_2)
    public Result<?> addGroup(@RequestBody SysAuthGroupMemberList2 memberList) {
        sysAuthGroupMemberService.saveExt2(memberList);
        return Result.OK("添加成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */

    @RequiresPermissions(value = {"authgroup:deletemember", "authgroup:deleterole", "deptedit:authdelete", "useredit:authdelete", "roleedit:authdelete"}, logical = Logical.OR)
    // @ApiOperation(value = "权限组-成员表-批量删除", notes = "权限组-成员表-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    @ResrunLogMethod(name = "批量删除权限组成员关系", operateType = OperateLogType.OPERATE_TYPE_4)
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        sysAuthGroupMemberService.removeExt(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    // @ApiOperation(value = "权限组-成员表-通过id查询", notes = "权限组-成员表-通过id查询")
    @GetMapping(value = "/queryById")
    @ResrunLogMethod(name = "查询权限组成员详情", operateType = OperateLogType.OPERATE_TYPE_1)
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        SysAuthGroupMember sysAuthGroupMember = sysAuthGroupMemberService.getById(id);
        if (sysAuthGroupMember == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(sysAuthGroupMember);
    }
}
