/**
 * @description 签约文件数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: DocFileVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocFileVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("签约文件数据对象")
public class SignFileVo implements Serializable {

    private static final long serialVersionUID = 1223645569560189433L;

    // @ApiModelProperty("签约文件id")
    private String id ;

    // @ApiModelProperty("签约文件名称")
    private String name ;

    // @ApiModelProperty("签约文件真实文件id")
    private String annexId ;

    // @ApiModelProperty("是否可改")
    private Integer isChange ;

}