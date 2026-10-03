/**
 * @description 业务权限对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: BusinessAuthVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: BusinessAuthVo
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务权限对象")
public class BusinessAuthVo implements Serializable {

    private static final long serialVersionUID = 8555184952265272469L;

    // @ApiModelProperty("授权类型，1用户(租户下用户)，2部门，3角色")
    private Integer authType ;

    // @ApiModelProperty("权限关联id，租户下用户id或者部门ID或者角色ID")
    private String authRelationId ;

    // @ApiModelProperty("权限关联id的名称，租户下用户名称或者部门名称或者角色名称")
    private String authRelationName ;


}