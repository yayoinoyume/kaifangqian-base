/**
 * @description 意愿校验确认参数
 */
package com.kaifangqian.modules.opensign.vo.base;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2024/4/7  15:41
 * @description:
 */
@Data
public class ConfirmPara {

    private String phone;

    private String email;

    private String password;

    private String name;

    private String idCard;
}