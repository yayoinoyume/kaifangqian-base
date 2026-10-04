/**
 * @description 企业用印明细对象
 */
package com.kaifangqian.modules.opensign.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: UseSealDetailDto
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: UseSealDetailDto
 * @author: Fusion
 * CreateTime:  2023/8/18  14:50
 * @copyright 资助审批电子签章系统
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("用印明细对象")
public class UseSealDetailDto {

    // @ApiModelProperty(value = "用印部门")
    private String useSealDeptId;     //用印部门

    // @ApiModelProperty(value = "业务类型")
    private Integer businessType;    //业务类型

    /**
     * 统计范围
     * 开始日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @ApiModelProperty(value = "开始日期")
    private String startTime;
    /**
     * 统计范围
     * 结束日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @ApiModelProperty(value = "结束日期")
    private String endTime;

}
