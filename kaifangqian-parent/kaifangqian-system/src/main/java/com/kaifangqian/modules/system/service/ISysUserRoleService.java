package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysRole;
import com.kaifangqian.modules.system.entity.SysUserRole;
import com.kaifangqian.modules.system.vo.SysUserRoleVO;
import com.kaifangqian.common.vo.TenantUserInfo;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    List<SysUserRole> queryByRoleIds(List<String> roleIds);

    List<SysUserRole> queryByUserIdAndTenantId(String userId, String tenantId);

    List<SysRole> getRolesByUserId(String userId);

    void saveExt(SysUserRoleVO sysUserRoleVO);

    void deleteByTenantIdAndUserIds(String tenantId, List<String> userIds);

    void deleteByRoleIds(List<String> roleIds);

    List<String> getMyRoleIds();

    List<TenantUserInfo> getTenantUsersByRoleIds(List<String> roleIds);

}
