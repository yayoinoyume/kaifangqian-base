/**
 * Discription:租户用户关系Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.system.entity.SysAppInfo;
import com.kaifangqian.modules.system.entity.SysTenantUserApp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysTenantUserAppMapper extends BaseMapper<SysTenantUserApp> {
    List<SysTenantUserApp> getAppIdsByUser(@Param("userId") String userId, @Param("tenantId") String tenantId, @Param("appCode") String appCode);

    List<SysAppInfo> queryUserApps(@Param("userId") String userId, @Param("tenantId") String tenantId);
}
