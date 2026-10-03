/**
 * @description 业务数据权限组表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignBusinessAuthPermission
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignBusinessAuthPermission
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_business_auth_permission")
// @ApiModel("业务数据权限组表")
public class SignBusinessAuthPermission implements Serializable {

    private static final long serialVersionUID = -7457083301818487886L;

    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("业务类型，1为签章，2为模板，3为文档，4为业务线")
    private Integer businessType ;

    // @ApiModelProperty("业务类型角色，具体数值参照枚举类")
    private Integer businessTypeRole ;

    // @ApiModelProperty("业务权限值")
    private Integer permissionCode ;

    // @ApiModelProperty("业务权限值")
    private String permissionValue ;

}