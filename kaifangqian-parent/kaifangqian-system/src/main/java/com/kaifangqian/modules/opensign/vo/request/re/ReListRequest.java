package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: ReListRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: ReListRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务线列表请求对象")
public class ReListRequest implements Serializable {

    private static final long serialVersionUID = 757223096674572667L;

    // @ApiModelProperty("名称")
    private String name ;

    // @ApiModelProperty("状态")
    private Integer status ;

    // @ApiModelProperty("分组id")
    private String folderId ;

    // @ApiModelProperty("页码")
    Integer pageNo = 1;

    // @ApiModelProperty("页码大小")
    Integer pageSize = 10 ;


}