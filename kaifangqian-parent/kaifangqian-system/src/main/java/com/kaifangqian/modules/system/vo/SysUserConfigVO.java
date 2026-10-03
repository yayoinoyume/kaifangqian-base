package com.kaifangqian.modules.system.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhenghuihan
 * @description 用户系统配置表
 * @createTime 2022/9/2 17:32
 */
@Data
public class SysUserConfigVO implements Serializable {

    @NotBlank(message = "通道类型")
    // @ApiModelProperty(value = "通道类型")
    private String type;

    @NotBlank(message = "校验码不能为空")
    // @ApiModelProperty(value = "验证码")
    private String captcha;

    @NotBlank(message = "校验码key不能为空")
    // @ApiModelProperty(value = "验证码key")
    private String captchaKey;

    @NotBlank(message = "密码不能为空")
    // @ApiModelProperty(value = "密码")
    private String password;

    private transient String confirmType;
}
