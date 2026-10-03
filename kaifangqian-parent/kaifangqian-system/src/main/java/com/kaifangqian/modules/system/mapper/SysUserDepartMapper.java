/**
 * Discription:用户部门Mapper
 */
package com.kaifangqian.modules.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.common.vo.TenantUserInfo;
import com.kaifangqian.modules.system.entity.SysDepart;
import com.kaifangqian.modules.system.vo.SysDepartRoleVO;
import com.kaifangqian.modules.system.vo.SysDepartUserVO;
import org.apache.ibatis.annotations.Param;
import com.kaifangqian.modules.system.entity.SysUserDepart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysUserDepartMapper extends BaseMapper<SysUserDepart> {

    IPage<SysDepartUserVO> queryUserByDepId(Page<SysDepartUserVO> page, @Param("depId") String depId, @Param("tenantId") String tenantId);

    IPage<SysDepartUserVO> getUserListByDepartId(Page<SysDepartUserVO> page, @Param("depId") String depId, @Param("tenantId") String tenantId);

    List<SysDepartRoleVO> getUserRolesByDepartId(@Param("depId") String depId, @Param("tenantId") String tenantId);

    List<SysDepart> getDepartsByUserId(@Param("userId") String userId);

    List<SysUserDepart> getUserDepartByUserIdAndDepartId(@Param("userId") String userId, @Param("tenantId") String tenantId, @Param("departId") String departId);

    List<TenantUserInfo> getTenantUsersByDeptIds(@Param("departIds") List<String> departIds);
}
