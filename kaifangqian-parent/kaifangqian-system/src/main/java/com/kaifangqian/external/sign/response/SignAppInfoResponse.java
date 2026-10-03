/**
 * @description 资助审批电子签章系统签署应用信息
 */
package com.kaifangqian.external.sign.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
// @ApiModel("资助审批电子签章系统签署应用信息")
public class SignAppInfoResponse implements Serializable {

    private static final long serialVersionUID = -4454807566099795221L;

    // @ApiModelProperty("签署应用名称")
    private String appName ;

    // @ApiModelProperty("签署应用appLogo,base64格式；")
    private String appLogo ;


}