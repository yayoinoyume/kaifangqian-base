/**
 * @description 签约文件图片数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocImageVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocImageVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("签约文件图片数据对象")
public class DocImageVo implements Serializable {

    private static final long serialVersionUID = -3032725568470650497L;

    // @ApiModelProperty("图片id")
    private String id ;

    // @ApiModelProperty("图片页码")
    private Integer page ;

    // @ApiModelProperty("图片真实文件id")
    private String annexId ;

    // @ApiModelProperty("图片宽")
    private String imageWidth ;

    // @ApiModelProperty("图片高")
    private String imageHeight ;
}