/**
 * @description 定时任务信息
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaskInfoFor3rdVO implements Serializable {

    private static final long serialVersionUID = -6524332271436917777L;

    // @ApiModelProperty("合同ID")
    private String signRuId;

    // @ApiModelProperty("账号")
    private String username;

    // @ApiModelProperty("身份信息")
    private String tenantName;

    // @ApiModelProperty("任务ID")
    private String taskId;

    // @ApiModelProperty("任务类型")
    private String taskType;
}