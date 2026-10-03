package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/1/3  15:51
 * @description: 邀请用户实体
 */
@Data
public class InviteUserVO {
    private String departId;
    private String tenantName;
    private String phone;
    private String email;
    private String invitationCode;
    private String url;
    private String departCode;
    private String tenantId;
}