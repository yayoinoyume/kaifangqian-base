package com.kaifangqian.modules.opensign.vo.response.ru;


// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckStatusResponse implements Serializable {

    private static final long serialVersionUID = 3684282734048702185L;

    // @ApiModelProperty("校验状态")
    private Integer checkStatus;

    // @ApiModelProperty("目标租户名称")
    private String targetTenantName;

    // @ApiModelProperty("当前用户名")
    private String currentUsername;

    // @ApiModelProperty("目标用户手机号")
    private String targetUserPhone;

    // @ApiModelProperty("目标用户邮箱")
    private String targetUserEmail;

}