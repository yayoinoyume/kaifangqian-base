package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author : zhenghuihan
 * create at:  2022/6/28  17:58
 * @description:用户实名结果信息
 */
@Data
public class TenantAuthVO {

    // @ApiModelProperty(value = "认证类型：1=新建企业认证、2=重新认证、3=认证变更")
    private Integer authType;

    // @ApiModelProperty(value = "租户id，新建不需要此参数")
    private String tenantId;

    // @ApiModelProperty(value = "姓名或企业名称")
    private String name;

    /**
     * 身份证号码或单位证件号码
     */
    // @ApiModelProperty(value = "身份证号或者组织机构代码")
    private String organizationNo;

    /**
     * 法定代表人
     */
    // @ApiModelProperty(value = "法人姓名")
    private String corporation;

    /**
     * 代表人证件号
     */
    // @ApiModelProperty(value = "法人身份证号")
    private String corporationNo;

    /**
     * 手机号
     */
    // @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 手机号
     */
    // @ApiModelProperty(value = "事项，创建不需要传")
    private Integer realItem;

    /**
     * 营业执照附件id
     */
    // @ApiModelProperty(value = "营业执照id")
    private String businessLicense;

    // @ApiModelProperty(value = "授权书")
    private String authorizeBook;

    /**
     * 国徽面
     */
    // @ApiModelProperty(value = "身份证-国徽面")
    private String idCardEmblem;

    /**
     *人像面
     */
    // @ApiModelProperty(value = "身份证-人像面")
    private String idCardFace;


    // @ApiModelProperty(value = "验证码")
    private String captcha;

    // @ApiModelProperty(value = "验证码key")
    private String captchaKey;

    // @ApiModelProperty(value = "自动生成签章")
    private Boolean autoSeal;


    private String submitIp;


    private String redirectUrl;
    private String signRuId;
    private String taskId;
}
