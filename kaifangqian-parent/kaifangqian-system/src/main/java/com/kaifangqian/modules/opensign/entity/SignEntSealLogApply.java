/**
 * @description 企业印章申请日志
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

/**
 * @Description: 企业印章申请日志
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignEntSealLogApply
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ent_seal_log_apply")
// @ApiModel("企业印章申请日志")
public class SignEntSealLogApply extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6802097065634578976L;

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

    // @ApiModelProperty("印章管理员id，印章所属系统租户下用户id")
    private String adminId ;

    // @ApiModelProperty("印章名称")
    private String sealName ;

    // @ApiModelProperty("印章样式（1、公章；2、圆形章；3、椭圆形；）")
    private Integer sealStyle ;

    // @ApiModelProperty("印章类型（1、公章；2、财务专用章；3、合同专用章；4、人事专用章；5、其他）")
    private Integer sealType ;

    // @ApiModelProperty("创建类型（1、模板创建；2、上传创建）")
    private Integer createType ;

    // @ApiModelProperty("颜色(1、红色；2、蓝色；3、黑色)")
    private Integer color ;

    // @ApiModelProperty("上排环绕文字")
    private String topText ;

    // @ApiModelProperty("横排文字")
    private String middleText ;

    // @ApiModelProperty("下弦文")
    private String bottomText ;

    // @ApiModelProperty("用途说明")
    private String description ;


    // @ApiModelProperty("停用原因")
    private String reason ;


    // @ApiModelProperty("企业签章id")
    private String sealId ;

    // @ApiModelProperty("申请操作类型,1、制作，2、编辑，3、章面变更，4、停用，5、激活，6、收缴，7销毁")
    private Integer operateType ;

    // @ApiModelProperty("申请状态（1、待提交，2、待重新提交，3、待审批，4、审批未通过，5、审批通过，6、作废）")
    private Integer applyStatus ;

    // @ApiModelProperty("流程实例id")
    private String processInstanceId ;


}