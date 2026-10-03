package com.kaifangqian.modules.system.vo;
/**
 * @author : zhenghuihan
 * create at:  2022/6/28  17:58
 * @description:用户实名结果信息
 */
public class TenantAuthResult {

    //1 = 企业  2个人
    private Integer tenantType;

    //企业名称或个人姓名
    private String businessName;

    //组织机构代码或个人身份证号
    private String businessCode;

    //法人姓名
    private String corporationName;

    //法人证件号
    private String corporationCode;


    //法人手机号
    private String corporationPhone;

    //认证提交人
    private String authorName;


    //认证提交人手机号
    private String authorPhone;

    //认证提交时间
    private String submitTime;

    //认证审核通过时间
    private String auditTime;

    //认证提交IP
    private String submitIp;

    //个人认证方式
    private String personalAuthType;

    //个人手机号
    private String personalPhone;
    //验证码
    private String captcha;

    public Integer getTenantType() {
        return tenantType;
    }

    public void setTenantType(Integer tenantType) {
        this.tenantType = tenantType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getCorporationCode() {
        return corporationCode;
    }

    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getCorporationPhone() {
        return corporationPhone;
    }

    public void setCorporationPhone(String corporationPhone) {
        this.corporationPhone = corporationPhone;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPhone() {
        return authorPhone;
    }

    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = authorPhone;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getSubmitIp() {
        return submitIp;
    }

    public void setSubmitIp(String submitIp) {
        this.submitIp = submitIp;
    }

    public String getPersonalAuthType() {
        return personalAuthType;
    }

    public void setPersonalAuthType(String personalAuthType) {
        this.personalAuthType = personalAuthType;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
