package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAuthGroupRole;
import com.kaifangqian.modules.system.vo.SysAuthGroupRoleVO;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限组-角色表
 * @createTime 2022/9/2 18:12
 */
public interface ISysAuthGroupRoleService extends IService<SysAuthGroupRole> {

    IPage<SysAuthGroupRoleVO> pageExt(String groupId, Page<SysAuthGroupRoleVO> page);

    void addExt(SysAuthGroupRoleVO req);

    void addExt2(SysAuthGroupRoleVO req);

    void deleteBatchExt(List<String> ids);

    void deleteByRoleIds(List<String> roleIds);

    List<SysAuthGroupRole> getByRoleId(String roleId);
}
