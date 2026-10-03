package com.kaifangqian.modules.system.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TenantAuthRequest {

    // @ApiModelProperty("单位名称")
    private String name;
    // @ApiModelProperty("申请日期-开始时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime ;
    // @ApiModelProperty("申请日期-结束时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime ;
    // @ApiModelProperty("审核状态")
    private Integer authStatus;

    private String tenantId;

    // @ApiModelProperty("租户类型")
    private Integer tenantType ;
}
