/**
 * @description 电子签服务开通，个人实名开通信息响应
 */
package com.kaifangqian.external.auth.response;

import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class IdentityAuthInfoForQueryResponse {

    private String unionId;
    private String contactUnionId;
    private String orderNo;
    private int orderStatus;
    private int userType;
    private int bizType;
    private String personVerifyMethod;
    private String companyVerifyMethod;
    private String name;
    private String idCard;
    private int idCardType;
    private String mobile;
    private String bankCard;
    private String companyName;
    private int companyType;
    private String creditCode;
    private String createTime;
    private String verifyTime;

}
