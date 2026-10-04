/**
 * @description 印章信息表Mapper
 */
package com.kaifangqian.modules.opensign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.opensign.dto.SealAuditDto;
import com.kaifangqian.modules.opensign.dto.UseSealDetailDto;
import com.kaifangqian.modules.opensign.entity.SignEntSeal;
import com.kaifangqian.modules.opensign.vo.base.SealAuditVo;
import com.kaifangqian.modules.opensign.vo.base.UseSealDetailVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Description: SignStasticsMapper
 * @Package: com.kaifangqian.modules.opensign.controller
 * @ClassName: SignStasticsMapper
 * @author: Fusion
 * CreateTime:  2023/8/22  9:53
 * @copyright 资助审批电子签章系统
 */

public interface SignStasticsMapper extends BaseMapper<SignEntSeal> {

    //印章统计相关统计
    Integer getUseCount(@Param("tenantId") String tenantId);

    Integer getStopCount(@Param("tenantId") String tenantId);

    Integer getCollectCount(@Param("tenantId") String tenantId);

    Integer getDestructionCount(@Param("tenantId") String tenantId);

    //用印统计相关统计
    Integer getElectronicUseSealCount(@Param("tenantId") String tenantId);

    Integer getPhysicsUseSealCount(@Param("tenantId") String tenantId);

    Integer getInterfaceUseSealCount(@Param("tenantId") String tenantId);


    IPage<UseSealDetailVo> getUseSealDetailList(Page page, @Param("req") UseSealDetailDto useSealDetailDto);

    List<UseSealDetailVo> getUseSealDetailList(@Param("req") UseSealDetailDto useSealDetailDto);

    IPage<SealAuditVo> getSealAuditList(Page page, @Param("req") SealAuditDto sealAuditDto);

    List<SealAuditVo> getSealAuditList(@Param("req") SealAuditDto sealAuditDto);

}
