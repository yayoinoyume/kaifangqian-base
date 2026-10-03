package com.kaifangqian.modules.opensign.vo.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealListResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: EntSealListResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("企业印章列表返回对象")
public class EntSealListResponse implements Serializable {

    private static final long serialVersionUID = -7474517752461766579L;

    // @ApiModelProperty("印章id")
    private String sealId ;
    // @ApiModelProperty("印章名称")
    private String sealName ;
    // @ApiModelProperty("附件id")
    private String annexId ;

    // @ApiModelProperty("印章状态（制作中、制作失败、已停用、已启用、已收缴、已销毁）")
    private Integer sealStatus ;

    // @ApiModelProperty("1有效，2失效")
    private Integer status ;
}