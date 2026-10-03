/**
 * Discription:租户用户关系表Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.kaifangqian.common.vo.TenantUserInfo;
import com.kaifangqian.modules.system.entity.SysTenantUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysTenantUserMapper extends BaseMapper<SysTenantUser> {

    List<SysTenantUser> getUserTenantByUserIdAndTenantId(@Param("userId") String userId, @Param("tenantId") String tenantId);

    List<SysTenantUser> getTenantsByUserIdAndAppId(@Param("userId") String userId, @Param("appId") String appId);

    List<TenantUserInfo> getAllTenantUsers();

    SysTenantUser getPersonalTenantUser(@Param("userId") String userId);
}
