/**
 * @description 任务信息
 */
package com.kaifangqian.common.system.vo;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @author : zhenghuihan
 * create at:  2022/3/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel(value = "任务操作执行人数据", description = "任务操作执行人数据")
public class TaskUserVO implements Serializable {
    // @ApiModelProperty(value = "id")
    private String uniqueId;
    // @ApiModelProperty(value = "执行人id")
    private String userId;
    // @ApiModelProperty(value = "执行人名称")
    private String username;
    // @ApiModelProperty(value = "执行人部门code")
    private String orgCode;


}
