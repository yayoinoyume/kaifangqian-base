/**
 * @description 业务线各类操作-请求对象
 */
package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: OperationRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: OperationRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线各类操作-请求对象")
public class OperationRequest implements Serializable {

    private static final long serialVersionUID = -5696781474287239312L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("业务线状态，1启用、2停用")
    private Integer status ;

    // @ApiModelProperty("业务线分组ID")
    private String folderId ;

}