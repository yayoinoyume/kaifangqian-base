/**
 * Discription:租户信息扩展Mapper
 */
package com.kaifangqian.modules.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaifangqian.modules.system.entity.TenantInfoExtend;
import com.kaifangqian.modules.system.vo.SysTenantInfoExtendVO;
import com.kaifangqian.modules.system.vo.TenantInfoDTO;
import com.kaifangqian.modules.system.vo.TenantQueryDTO;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface TenantInfoExtendMapper extends BaseMapper<TenantInfoExtend> {
    IPage<TenantInfoDTO> pageExt(Page<TenantInfoDTO> page, @Param("req") TenantQueryDTO req);

    List<SysTenantInfoExtendVO> listMyTenant(@Param("userId") String userId);
}
