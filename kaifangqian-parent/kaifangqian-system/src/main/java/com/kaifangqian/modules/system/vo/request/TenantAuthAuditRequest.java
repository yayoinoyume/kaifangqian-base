package com.kaifangqian.modules.system.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TenantAuthAuditRequest {

    // @ApiModelProperty(value = "审核不通过原因")
    private String checkMsg;

    // @ApiModelProperty(value = "实名认证记录id")
    private String logId;

    // @ApiModelProperty(value = "审核是否通过")
    private Boolean authStatus;
}
