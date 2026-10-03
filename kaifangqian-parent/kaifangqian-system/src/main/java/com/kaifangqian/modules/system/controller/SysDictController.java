package com.kaifangqian.modules.system.controller;


import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysDict;
import com.kaifangqian.annotation.ResrunLogMethod;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.enums.OperateLogType;
import com.kaifangqian.common.system.query.QueryGenerator;
import com.kaifangqian.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import com.kaifangqian.modules.system.service.ISysDictService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @Author zhh
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/sys/dict")
@Slf4j
@ResrunLogModule(name = "字典管理模块")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    /**
     * @param sysDict
     * @return
     * @功能：新增
     */
    @RequiresPermissions(value = {"dict:add", "dictcategory:add"}, logical = Logical.OR)
    @ResrunLogMethod(name = "新增字典", operateType = OperateLogType.OPERATE_TYPE_2)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> add(@RequestBody SysDict sysDict) {
        sysDictService.saveExt(sysDict);
        return Result.OK();
    }

    /**
     * @param
     * @return
     * @功能：详情
     */
    @RequiresPermissions(value = {"dict:info", "dictcategory:info"}, logical = Logical.OR)
    @ResrunLogMethod(name = "查询字典详情", operateType = OperateLogType.OPERATE_TYPE_1)
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Result<SysDict> info(@RequestParam(name = "id", required = true) String id) {
        return Result.OK(sysDictService.getById(id));
    }

    /**
     * @param sysDict
     * @return
     * @功能：编辑
     */
    @RequiresPermissions(value = {"dict:edit", "dictcategory:edit"}, logical = Logical.OR)
    @ResrunLogMethod(name = "编辑字典", operateType = OperateLogType.OPERATE_TYPE_3)
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<?> edit(@RequestBody SysDict sysDict) {
        sysDictService.updateExt(sysDict);
        return Result.OK();
    }


    /**
     * @param sysDict
     * @return
     * @功能：分页查询(分层查询)
     */
    @ResrunLogMethod(name = "分页查询字典列表", operateType = OperateLogType.OPERATE_TYPE_1)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<IPage<SysDict>> queryPageList(SysDict sysDict, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize, HttpServletRequest req) {
        QueryWrapper<SysDict> queryWrapper = QueryGenerator.initQueryWrapper(sysDict, req.getParameterMap());
        Page<SysDict> page = new Page<SysDict>(pageNo, pageSize);
        IPage<SysDict> pageList = sysDictService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * @param sysDict
     * @param req
     * @return
     * @功能：获取树形字典数据
     */
    @ResrunLogMethod(name = "查询字典树", operateType = OperateLogType.OPERATE_TYPE_1)
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    public Result<List<Tree<String>>> treeList(SysDict sysDict, HttpServletRequest req) {
        QueryWrapper<SysDict> queryWrapper = QueryGenerator.initQueryWrapper(sysDict, req.getParameterMap());
        List<SysDict> list = sysDictService.list(queryWrapper);
        List<Tree<String>> tree = sysDictService.getTreeList(list);

        return Result.OK(tree);
    }

    /**
     * @param id
     * @return
     * @功能：删除
     */
    @RequiresPermissions(value = {"dict:delete", "dictcategory:delete"}, logical = Logical.OR)
    @ResrunLogMethod(name = "删除字典", operateType = OperateLogType.OPERATE_TYPE_4)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<SysDict> delete(@RequestParam(name = "id", required = true) String id) {
        sysDictService.deleteExt(id);
        return Result.OK();
    }
}
