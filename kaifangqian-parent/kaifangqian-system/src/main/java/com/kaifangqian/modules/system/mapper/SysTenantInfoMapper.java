/**
 * Discription:租户表Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysTenantInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.system.vo.SysTenantAppVersionVO;
import com.kaifangqian.modules.system.vo.SysTenantInfoQuery;
import com.kaifangqian.modules.system.vo.SysTenantInfoRes;
import com.kaifangqian.modules.system.vo.TenantUser3rd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysTenantInfoMapper extends BaseMapper<SysTenantInfo> {

    IPage<SysTenantInfoRes> pageExt(Page page, @Param("query") SysTenantInfoQuery query);

    List<SysTenantAppVersionVO> getTenantApps(@Param("id") String id);

    List<TenantUser3rd> getByUsernameAndTenantName(@Param("username") String username, @Param("tenantName") String tenantName);

    SysTenantInfo getPersonalByTenantUserId(@Param("tenantUserId") String tenantUserId);
}
