/**
 * Discription:菜单权限表Mapper
 */
package com.kaifangqian.modules.system.mapper;

import java.util.List;

import com.kaifangqian.modules.system.vo.UserAuthDataQueryVO;
import org.apache.ibatis.annotations.Param;
import com.kaifangqian.modules.system.entity.SysPermission;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     * 根据用户查询用户权限
     */
    List<SysPermission> queryByUser(@Param("query") UserAuthDataQueryVO query);

    List<SysPermission> listTenantAppAllMenu(@Param("tenantId") String tenantId, @Param("appId") String appId, @Param("parentId") String parentId, @Param("types") List<Integer> types);
}
