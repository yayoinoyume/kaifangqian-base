package com.kaifangqian.modules.opensign.vo.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealAuthorizedResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: EntSealAuthorizedResponse
 * @author: FengLai_Gong
 */
// @ApiModel("企业签章授权人数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntSealAuthorizedResponse implements Serializable {

    private static final long serialVersionUID = 1432669025971390480L;

    // @ApiModelProperty(value = "租户下用户ID")
    private String tenantUserId ;

    // @ApiModelProperty(value = "租户下用户ID")
    private String id ;

    // @ApiModelProperty(value = "租户ID")
    private String tenantId;

    // @ApiModelProperty(value = "用户id")
    private String userId;

    // @ApiModelProperty(value = "用户别称")
    private String nickName;




}