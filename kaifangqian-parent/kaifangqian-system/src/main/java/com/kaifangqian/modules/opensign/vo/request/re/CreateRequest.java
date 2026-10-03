/**
 * @description 业务线配置-创建-请求对象
 */
package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: CreateRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: CreateRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务线配置-创建-请求对象")
public class CreateRequest implements Serializable {

    private static final long serialVersionUID = 7849086805789804484L;

    // @ApiModelProperty("业务线名称")
    private String name ;

    // @ApiModelProperty("分组id")
    private String folderId ;



}