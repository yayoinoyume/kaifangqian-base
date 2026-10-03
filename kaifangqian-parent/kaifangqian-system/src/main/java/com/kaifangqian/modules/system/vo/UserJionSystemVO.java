package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/1/3  17:55
 * @description: 用户加入系统
 */
@Data
public class UserJionSystemVO {
    //个人1 企业2
    private Integer tenantType;
    private String realName;
    private String email;
    private String phone;

    private String password;

    // @ApiModelProperty(value = "url参数")
    private String redisKey;

    // @ApiModelProperty(value = "验证码")
    private String captcha;

    // @ApiModelProperty(value = "验证码key")
    private String captchaKey;

    private String account;
}