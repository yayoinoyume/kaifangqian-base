/**
 * @description 企业印章操作日志
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
 * @Description: 企业印章操作日志
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignEntSealLogOperate
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ent_seal_log_operate")
// @ApiModel("企业印章操作日志")
public class SignEntSealLogOperate implements Serializable {

    private static final long serialVersionUID = 764128883878215317L;

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

    // @ApiModelProperty("印章id")
    private String sealId ;

    // @ApiModelProperty("操作类型,1、制作，2、编辑，3、章面变更，4、停用，5、激活，6、收缴，7销毁")
    private Integer operateType ;

    // @ApiModelProperty("操作时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime ;


}