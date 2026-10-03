/**
 * @description 电子签签署订单请求参数
 */
package com.kaifangqian.external.sign.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
// @ApiModel("合同签署订单请求对象")
public class SignOrderRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    // @ApiModelProperty("签署方的唯一性标识")
    private String unionId;

    // @ApiModelProperty(value = "签署方类型",allowableValues = "COMPANY,PERSONAL")
    private String tenantType;

    // @ApiModelProperty("签署操作人唯一标识，当签署方类型为COMPANY时，需要传递")
    private String operatorUnionId;

    // @ApiModelProperty("免意愿快捷签署")
    private String agreeSkipWillingness;

    // @ApiModelProperty("签署意愿验证方式")
    private List<String> verifyTypes;

    //value字段值为：required（须实名认证）、allowed（允许不实名认证）、not_required（无需实名认证）
    private String personalSignAuth ;

    //资助审批电子签章系统客户账号
    private String clientUsername;

    // @ApiModelProperty("合同编号")
    private String contractId;

    // @ApiModelProperty("合同名称")
    private String contractName;

    // @ApiModelProperty("业务唯一标识")
    private String bizId;

    // @ApiModelProperty("回调页面地址")
    private String callbackPage;

    // @ApiModelProperty("异步回调地址")
    private String signCallbackUrl;

}