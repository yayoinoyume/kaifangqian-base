/**
 * @description 模板申请异常日志
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
 * @Description: SignTemplateApplyLog
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignTemplateApplyLog
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_log_error")
// @ApiModel("模板申请异常日志")
public class SignTemplateLogError implements Serializable {

    private static final long serialVersionUID = -5415319770350934638L;

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

    // @ApiModelProperty("模板id")
    private String templateId ;

    // @ApiModelProperty("模板申请记录id")
    private String templateLogApplyId ;

    // @ApiModelProperty("流程实例id")
    private String processInstanceId ;

    // @ApiModelProperty("任务id")
    private String taskDataId ;

    // @ApiModelProperty("异常类型")
    private Integer errorType ;

    // @ApiModelProperty("异常原因")
    private String errorText ;

    // @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}