/**
 * @description 定时任务信息
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaskSearchFor3rdVO implements Serializable {

    private static final long serialVersionUID = -6524332271436917777L;

    // @ApiModelProperty("合同ID")
    private String signRuId;

    // @ApiModelProperty("账号")
    private String username;

    // @ApiModelProperty("身份信息")
    private String tenantName;

    // @ApiModelProperty("任务ID")
    private String taskId;

    // @ApiModelProperty("是否免登录")
    private Boolean noLogin;

    // @ApiModelProperty("链接失效时间")
    private Date pageUrlExpireTime;
}