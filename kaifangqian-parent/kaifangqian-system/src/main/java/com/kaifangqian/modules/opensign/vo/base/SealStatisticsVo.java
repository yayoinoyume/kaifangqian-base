/**
 * @description 印章统计返回对象
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
 * CreateTime:  2023/8/18  10:53
 * @copyright 资助审批电子签章系统
 */

@Data
// @ApiModel("印章统计返回对象")
public class SealStatisticsVo {
    // @ApiModelProperty(value = "全部印章数")
    private Integer allSealsCount = 0;
    // @ApiModelProperty(value = "印章已启用数")
    private Integer useCount = 0;
    // @ApiModelProperty(value = "印章已启用数")
    private Integer stopCount = 0;
    // @ApiModelProperty(value = "印章已收缴数")
    private Integer collectCount = 0;
    // @ApiModelProperty(value = "印章已销毁数")
    private Integer destructionCount = 0;
}
