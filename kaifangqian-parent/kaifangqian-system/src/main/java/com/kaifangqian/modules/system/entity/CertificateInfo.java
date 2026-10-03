package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 证书信息表
 * </p>
 *
 * @author Administrator
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("certificate_info")
public class CertificateInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 证书所属类型（1、个人；2、企业）
     */
    @TableField("holder_type")
    private Integer holderType;

    /**
     * 证书主题
     */
    @TableField("cert_subject")
    private String certSubject;

    /**
     * 证书序列号
     */
    @TableField("cert_suqe_no")
    private String certSuqeNo;

    /**
     * 证书颁发时间
     */
    @TableField("issue_time")
    private Date issueTime;

    /**
     * 颁发机构
     */
    @TableField("issue_org")
    private String issueOrg;

    /**
     * 证书密码
     */
    @TableField("cert_password")
    private String certPassword;

    /**
     * 证书类型（1、云证书）
     */
    @TableField("cert_type")
    private Integer certType;

    /**
     * 加密算法（1、RSA；2、SM2）
     */
    @TableField("algorithm_type")
    private String algorithmType;

    /**
     * 证书有效期起始时间
     */
    @TableField("term_of_validity_start_time")
    private Date termOfValidityStartTime;

    /**
     * 证书有效期结束时间
     */
    @TableField("term_of_validity_end_time")
    private Date termOfValidityEndTime;

    /**
     * 存储介质
     */
    @TableField("storage_medium")
    private String storageMedium;

    /**
     * 证书唯一码
     **/
    @TableField("unique_code")
    private String uniqueCode ;

}
