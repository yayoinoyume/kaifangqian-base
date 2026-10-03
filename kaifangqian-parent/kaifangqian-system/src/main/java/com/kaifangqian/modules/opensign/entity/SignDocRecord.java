/**
 * @description 文档签署记录
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: SignDocRecord
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignDocRecord
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_doc_record")
// @ApiModel("文档签署记录")
public class SignDocRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5139997344229143016L;

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

    // @ApiModelProperty("签章id")
    private String sealId ;

    // @ApiModelProperty("证书id")
    private String certId ;

    // @ApiModelProperty("操作时间")
    private Date operateTime ;

    // @ApiModelProperty("操作状态,0为草稿，1为填写，2为签署,3拒绝签署")
    private Integer operateStatus ;

    // @ApiModelProperty("操作备注")
    private String operateNotes ;

    // @ApiModelProperty("意愿校验类型（多选：0、无需校验；1、短信校验；2、扫脸校验")
    private Integer validateType ;

    // @ApiModelProperty("意愿校验状态，1通过，2未通过")
    private Integer validateStatus ;

    // @ApiModelProperty("是否为最新签署的，1为是，2为否")
    private Integer isCurrent ;

    // @ApiModelProperty("文件id")
    private String annexId ;

}