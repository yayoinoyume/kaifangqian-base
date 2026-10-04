/**
 * @description 用印统计返回对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: SealStatisticsVo
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: SealStatisticsVo
 * @author: Fusion
 * CreateTime:  2023/8/18  13:53
 * @copyright 资助审批电子签章系统
 */

// @ApiModel("用印统计返回对象")
@Data
public class UseSealStatisticsVo {
    // @ApiModelProperty(value = "总用印次数")
    private Integer totalUseSealsCount = 0;
    // @ApiModelProperty(value = "电子章用印次数")
    private Integer electronicUseSealCount = 0;
    // @ApiModelProperty(value = "物理章用印次数")
    private Integer physicsUseSealCount = 0;
    // @ApiModelProperty(value = "接口用印次数")
    private Integer interfaceUseSealCount = 0;
}
