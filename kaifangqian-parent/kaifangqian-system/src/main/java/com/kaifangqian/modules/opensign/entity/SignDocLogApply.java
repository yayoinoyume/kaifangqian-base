/**
 * @description 文档审批日志
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: SignDocApplyLog
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignDocApplyLog
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_doc_log_apply")
// @ApiModel("文档审批日志")
public class SignDocLogApply implements Serializable {

    private static final long serialVersionUID = 4388352557992618138L;

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

    // @ApiModelProperty("文档id")
    private String docId ;

    // @ApiModelProperty("流程实例id")
    private String processInstanceId ;

    // @ApiModelProperty("操作时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime ;

    // @ApiModelProperty("文档状态（待发起、待重新发起、待审批、审批未通过、待签章、签署失败、已完成、已过期、作废")
    private Integer applyStatus ;

    // @ApiModelProperty("删除标志：0未删除，1已删除")
    private Boolean deleteFlag;

    // @ApiModelProperty("删除人")
    private String deleteBy;

    // @ApiModelProperty("删除时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteTime;
}