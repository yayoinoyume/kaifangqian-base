/**
 * @description 模版文件夹模板关联表
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
 * @Description: SignTemplateFolderRelation
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignTemplateFolderRelation
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_folder_relation")
// @ApiModel("模版文件夹模板关联表")
public class SignTemplateFolderRelation extends BaseEntity implements Serializable {


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

    // @ApiModelProperty("'模板主键")
    private String templateId;

    // @ApiModelProperty("'模板文件夹主键")
    private String templateFolderId ;


}