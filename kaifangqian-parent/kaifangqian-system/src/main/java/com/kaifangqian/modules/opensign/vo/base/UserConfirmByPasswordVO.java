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
public class UserConfirmByPasswordVO {

    @NotBlank(message = "类型不能为空")
    private String confirmType;

    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    @NotBlank(message = "签约密码不能为空")
    // @ApiModelProperty(value = "签约密码")
    private String password;
}