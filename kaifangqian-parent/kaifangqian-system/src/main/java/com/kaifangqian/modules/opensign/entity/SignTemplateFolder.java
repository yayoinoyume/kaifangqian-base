/**
 * @description 模板文件夹表
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
 * @Description: SignTemplateFolder
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignTemplateFolder
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_folder")
// @ApiModel("模板文件夹表")
public class SignTemplateFolder extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 5269988885074900995L;

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

    // @ApiModelProperty("模板父文件夹id")
    private String parentTemplateFolderId ;

    // @ApiModelProperty("模板文件夹名称")
    private String name;



}