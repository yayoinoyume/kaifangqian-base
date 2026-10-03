/**
 * @description 意愿检验数据
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : zhenghuihan
 * create at:  2022/8/1  17:01
 * @description:
 */
@Data
public class UserConfirmByCodeVO {

    @NotBlank(message = "校验类型不能为空")
    private String confirmType;

    @NotBlank(message = "类型不能为空")
    private String type;

    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    @NotBlank(message = "校验码不能为空")
    // @ApiModelProperty(value = "验证码")
    private String captcha;

    @NotBlank(message = "校验码key不能为空")
    // @ApiModelProperty(value = "验证码key")
    private String captchaKey;

    // @ApiModelProperty(value = "签约密码")
    private String password;
}