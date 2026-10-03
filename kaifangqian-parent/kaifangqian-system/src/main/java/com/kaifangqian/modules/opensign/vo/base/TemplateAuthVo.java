/**
 * @description 模版权限-数据对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Description: TemplateAuthVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: TemplateAuthVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("模版权限-数据对象")
public class TemplateAuthVo implements Serializable {

    private static final long serialVersionUID = 3062709848552403884L;

    // @ApiModelProperty("id")
    private String id ;

    // @ApiModelProperty("模版主表id")
    private String templateId;

    // @ApiModelProperty("权限类型，1管理员，2使用范围")
    private Integer authType ;

    // @ApiModelProperty("用户类型")
    private Integer userType ;

    // @ApiModelProperty("租户用户id")
    private String tenantUserId ;

    // @ApiModelProperty("租户用户名称")
    private String tenantUserName ;

}