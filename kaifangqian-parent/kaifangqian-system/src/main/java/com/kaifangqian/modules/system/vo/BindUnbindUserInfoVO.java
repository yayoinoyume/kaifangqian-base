package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/8/1  18:07
 * @description:
 */
@Data
public class BindUnbindUserInfoVO {

    private String type;

    private String phone;

    private String email;

    private String password;

    // @ApiModelProperty(value = "验证码")
    private String captcha;

    // @ApiModelProperty(value = "验证码key")
    private String captchaKey;
}