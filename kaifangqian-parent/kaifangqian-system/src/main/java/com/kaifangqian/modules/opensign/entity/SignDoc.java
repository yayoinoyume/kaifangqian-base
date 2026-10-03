/**
 * @description 文档表
 */
package com.kaifangqian.modules.opensign.entity;

/**
 * @Description: SignDoc
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignDoc
 * @author: FengLai_Gong
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sign_doc")
// @ApiModel("文档表")
public class SignDoc extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4897247797762535115L;

    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("印章所属系统租户id")
    private String sysTenantId ;

    // @ApiModelProperty("印章所属系统账号id")
    private String sysAccountId ;

    // @ApiModelProperty("印章所属系统租户下用户id")
    private String sysUserId ;

    // @ApiModelProperty("印章所属系统部门编码")
    private String sysOrgCode ;

    // @ApiModelProperty("印章所属系统部门id")
    private String sysDeptId ;

    // @ApiModelProperty("文档主题")
    private String docSubject ;

    // @ApiModelProperty("业务类型字典id")
    private String businessType ;

    // @ApiModelProperty("用印场景类型（1、加盖电子印章；2、加盖物理印章；")
    private Integer sceneType ;

    // @ApiModelProperty("用章类型")
    private Integer sealType ;

    // @ApiModelProperty("用印份数")
    private Integer useCount ;

    // @ApiModelProperty("签章id")
    private String sealId ;

    // @ApiModelProperty("用印事由")
    private String reason ;

    // @ApiModelProperty("发往单位")
    private String sendDept ;

    // @ApiModelProperty("签署截止时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime ;

    // @ApiModelProperty("备注")
    private String note ;

    // @ApiModelProperty("文档状态（1、待发起、2待重新发起、3待审批、4、审批未通过、待签章、签署失败、已完成、已过期、作废）")
    private Integer docStatus ;

    // @ApiModelProperty("发起时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime ;



}