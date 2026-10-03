/**
 * Discription:租户应用版本Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysTenantAppVersion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.system.vo.SysTenantAppVersionVO;
import com.kaifangqian.modules.system.vo.TenantUserAppReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysTenantAppVersionMapper extends BaseMapper<SysTenantAppVersion> {
    List<SysTenantAppVersionVO> getTenantsApps(@Param("tenantIds") List<String> tenantIds);

    IPage<SysTenantAppVersionVO> pageExt(Page<SysTenantAppVersionVO> page, @Param("req") TenantUserAppReq req);
}
