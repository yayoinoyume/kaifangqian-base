/**
 * Discription:用户角色表Mapper
 */
package com.kaifangqian.modules.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.common.vo.TenantUserInfo;
import com.kaifangqian.modules.system.entity.SysRole;
import com.kaifangqian.modules.system.vo.SysRoleUserVO;
import org.apache.ibatis.annotations.Param;
import com.kaifangqian.modules.system.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    IPage<SysRoleUserVO> getUsersByRoleId(Page page, @Param("roleId") String roleId, @org.apache.ibatis.annotations.Param("departIds") List<String> departIds, @Param("tenantId") String tenantId);

    List<String> getRoleIdsByUser(@Param("tenantId") String tenantId, @Param("userId") String userId);

    List<SysRole> getRolesByUserId(@Param("userId") String userId);

    List<TenantUserInfo> getTenantUsersByRoleIds(@org.apache.ibatis.annotations.Param("roleIds") List<String> roleIds);
}
