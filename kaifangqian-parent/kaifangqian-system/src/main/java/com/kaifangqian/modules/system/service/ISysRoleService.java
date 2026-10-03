package com.kaifangqian.modules.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysRole;
import com.kaifangqian.modules.system.vo.SysRoleUserVO;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 批量删除角色
     *
     * @param roleIds
     * @return
     */
    boolean deleteBatchRole(List<String> roleIds);

    /**
     * 根据部门id查询用户信息
     *
     * @param roleId
     * @return
     */
    IPage<SysRoleUserVO> getUsersByRoleId(String roleId, Page<SysRoleUserVO> page);

    void saveExt(SysRole sysRole);

    SysRole getByIdExt(String id);

    void updateExt(SysRole sysRole);

    List<SysRole> getByEntity(SysRole sysRole);

    List<Tree<String>> getTreeList(List<SysRole> list);

    List<Tree<String>> getTreeListForSelect(List<SysRole> list);

    List<SysRole> getMyRoles();

    //签章系统使用
    List<SysRole> getTenantRoles();

    List<SysRole> findSysRoleByRoleIds(List<String> roleIds);
}
