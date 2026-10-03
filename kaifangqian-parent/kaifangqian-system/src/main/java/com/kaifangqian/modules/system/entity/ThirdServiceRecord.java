package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.kaifangqian.common.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 第三方接口调用记录表
 * </p>
 *
 * @author Administrator
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("third_service_record")
public class ThirdServiceRecord extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 第三方类型
     */
    @TableField("service_type")
    private String serviceType;

    /**
     * 调用地址
     */
    @TableField("service_url")
    private String serviceUrl;

    /**
     * 请求参数JSON
     */
    @TableField("req_para")
    private String reqPara;

    /**
     * 请求成功标识
     */
    @TableField("success_flag")
    private Boolean successFlag;

    /**
     * 返回参数JSON
     */
    @TableField("res_para")
    private String resPara;

    /**
     * 所属账户
     */
    @TableField("sys_account_id")
    private String sysAccountId;

    /**
     * 所属租户
     */
    @TableField("sys_tenant_id")
    private String sysTenantId;

    /**
     * 所属用户
     */
    @TableField("sys_user_id")
    private String sysUserId;

    /**
     * 所属部门
     */
    @TableField("sys_org_code")
    private String sysOrgCode;

    @TableField("order_no")
    private String orderNo;
}
