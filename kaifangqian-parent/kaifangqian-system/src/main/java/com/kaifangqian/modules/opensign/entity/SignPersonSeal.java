/**
 * @description 个人签名表
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
 * @Description: SignPersonSeal
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignPersonSeal
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_person_seal")
// @ApiModel("个人签名")
public class SignPersonSeal extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3932283714206521914L;

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

    // @ApiModelProperty("印章名称")
    private String sealName ;

    // @ApiModelProperty("是否为默认，1为默认，2为非默认")
    private Integer isDefault ;

    // @ApiModelProperty("1有效，2失效")
    private Integer status ;

    // @ApiModelProperty("印章生成类型：TEMPLATE：模板生成、HAND：手写签名")
    private String sealType ;


}