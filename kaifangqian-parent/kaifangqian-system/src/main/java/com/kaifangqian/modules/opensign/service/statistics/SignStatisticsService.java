/**
 * @description 统计分析服务接口
 */
package com.kaifangqian.modules.opensign.service.statistics;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.opensign.dto.SealAuditDto;
import com.kaifangqian.modules.opensign.dto.UseSealDetailDto;
import com.kaifangqian.modules.opensign.vo.base.SealAuditVo;
import com.kaifangqian.modules.opensign.vo.base.SealStatisticsVo;
import com.kaifangqian.modules.opensign.vo.base.UseSealDetailVo;
import com.kaifangqian.modules.opensign.vo.base.UseSealStatisticsVo;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Description: 统计分析服务接口
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: SignStatisticsServiceImpl
 * @author: Fusion
 * CreateTime:  2023/8/18  10:53
 * @copyright 资助审批电子签章系统
 */
public interface SignStatisticsService{
    /**
     * 印章统计
     */
    SealStatisticsVo sealStatistics();

    /**
     * 用印统计
     */
    UseSealStatisticsVo useSealStatistics();

    /**
     * 用印明细-分页
     */
    IPage<UseSealDetailVo> useSealDetailList(Page<UseSealDetailVo> page, UseSealDetailDto useSealDetailDto);

    /**
     * 印章审计
     */
    IPage<SealAuditVo> sealAuditList(Page<SealAuditVo> page, SealAuditDto sealAuditDto);

    /**
     * 导出用印统计报表
     */
    void exportUseSealStatistic(HttpServletResponse response,UseSealDetailDto useSealDetailDto);

    /**
     * 导出用印审计报表
     */
    void exportSealAuditStatistic(HttpServletResponse response,SealAuditDto sealAuditDto);

    /**
     * 用印明细-列表
     */
    List<UseSealDetailVo> useSealDetailList(UseSealDetailDto useSealDetailDto);
}
