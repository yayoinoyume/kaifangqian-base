package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author : zhenghuihan
 * create at:  2022/8/1  17:01
 * @description: 用户修改密码vo
 */
@Data
public class UserPasswordUpdateVO {

    @NotBlank(message = "类型不能为空")
    private String type;

    private String username;

    private String oldpassword;

    @NotBlank(message = "新密码不能为空")
    private String newpassword;

    @NotBlank(message = "新确认密码不能为空")
    private String confirmpassword;

    private String phone;

    private String email;

    // @ApiModelProperty(value = "验证码")
    private String captcha;

    // @ApiModelProperty(value = "验证码key")
    private String captchaKey;

    @NotNull(message = "密码安全级别不能为空")
    private String passwordLevel;
}