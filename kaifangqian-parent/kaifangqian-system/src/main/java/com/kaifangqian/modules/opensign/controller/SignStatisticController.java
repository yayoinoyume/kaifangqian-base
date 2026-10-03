/**
 * @description 业务线运行实例-统计分析
 */
package com.kaifangqian.modules.opensign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.opensign.dto.SealAuditDto;
import com.kaifangqian.modules.opensign.dto.UseSealDetailDto;
import com.kaifangqian.modules.opensign.service.statistics.SignStatisticsService;
import com.kaifangqian.modules.opensign.vo.base.SealAuditVo;
import com.kaifangqian.modules.opensign.vo.base.SealStatisticsVo;
import com.kaifangqian.modules.opensign.vo.base.UseSealDetailVo;
import com.kaifangqian.modules.opensign.vo.base.UseSealStatisticsVo;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: SignStatisticController
 * @Package: com.kaifangqian.modules.opensign.controller
 * @ClassName: SignStatisticController
 * @author: Fusion
 * CreateTime:  2023/8/18  10:53
 * @copyright 本平台运营方
 */
@Slf4j
@RestController
@RequestMapping("/sign/statistics")
@ResrunLogModule(name = "统计分析")
// @Api(tags = "电子印章-统计分析")
public class SignStatisticController {

    @Autowired
    private SignStatisticsService signStatisticsService;

    /**
     * 印章统计
     */
    // @ApiOperation(value = "印章统计", notes = "印章统计")
    @GetMapping(value = "/seal")
    public Result<SealStatisticsVo> sealStatistics() {
        SealStatisticsVo sealStatisticsVo = signStatisticsService.sealStatistics();
        return Result.OK(sealStatisticsVo);
    }

    /**
     * 用印统计
     */
    // @ApiOperation(value = "用印统计", notes = "用印统计")
    @GetMapping(value = "/useSeal")
    public Result<UseSealStatisticsVo> useSealStatistics() {
        UseSealStatisticsVo sealStatisticsVo = signStatisticsService.useSealStatistics();
        return Result.OK(sealStatisticsVo);
    }


    /**
     * 用印明细
     */
    // @ApiOperation(value = "用印明细", notes = "用印明细")
    @GetMapping(value = "/useSealDetail")
    public Result<IPage<UseSealDetailVo>> useSealDetail(UseSealDetailDto useSealDetailDto,
                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<UseSealDetailVo> page = new Page<UseSealDetailVo>(pageNo, pageSize);
        IPage<UseSealDetailVo> pageList = signStatisticsService.useSealDetailList(page, useSealDetailDto);
        return Result.OK(pageList);
    }


    /**
     * 用印审计
     */
    // @ApiOperation(value = "用印审计", notes = "用印审计")
    @GetMapping(value = "/useSealAudit")
    public Result<IPage<SealAuditVo>> useSealAudit(SealAuditDto sealAuditDto,
                                  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SealAuditVo> page = new Page<SealAuditVo>(pageNo, pageSize);
        IPage<SealAuditVo> pageList = signStatisticsService.sealAuditList(page, sealAuditDto);
        return Result.OK(pageList);
    }

    /**
     * 用印统计报表
     */
    // @ApiOperation(value = "用印统计报表", notes = "用印统计报表")
    @GetMapping(value = "/useSealReport")
    public void getUseSealReport(HttpServletResponse response,UseSealDetailDto useSealDetailDto) {
        signStatisticsService.exportUseSealStatistic(response,useSealDetailDto);
    }

    /**
     * 印章审计报表
     */
    // @ApiOperation(value = "印章审计报表", notes = "印章审计报表")
    @GetMapping(value = "/sealAuditReport")
    public void getSealAuditReport(HttpServletResponse response,SealAuditDto sealAuditDto) {
        signStatisticsService.exportSealAuditStatistic(response,sealAuditDto);
    }

}
