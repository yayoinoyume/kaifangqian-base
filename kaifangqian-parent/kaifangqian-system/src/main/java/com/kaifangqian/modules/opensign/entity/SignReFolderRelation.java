/**
 * @description 业务线文件夹模板关联表
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
@TableName("sign_re_folder_relation")
// @ApiModel("业务线文件夹模板关联表")
public class SignReFolderRelation extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -8863212324755880654L;

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

    // @ApiModelProperty("'业务线主键")
    private String signReId;

    // @ApiModelProperty("'业务线文件夹主键")
    private String signReFolderId ;


}