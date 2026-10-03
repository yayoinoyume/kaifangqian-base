package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : zhenghuihan
 * create at:  2022/8/2  09:52
 * @description: 验证码登录vo
 */
@Data
public class CaptchLoginVO {

    private String username;

    private String phone;

    private String email;

    // @ApiModelProperty(value = "验证码")
    @NotBlank
    private String captcha;

    // @ApiModelProperty(value = "验证码key")
    @NotBlank
    private String captchaKey;

    private String password;

    private String appCode;
}