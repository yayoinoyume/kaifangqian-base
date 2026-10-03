/**
 * @description 图片数据
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: ImageVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: ImageVo
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("图片数据")
public class ImageVo implements Serializable {

    private static final long serialVersionUID = -5821670742164714572L;

    // @ApiModelProperty("图片数据id")
    private String id ;
    // @ApiModelProperty("关联文件id")
    private String annexId;
    // @ApiModelProperty("页码")
    private Integer page ;

    // @ApiModelProperty("图片宽")
    private String imageWidth ;

    // @ApiModelProperty("图片高")
    private String imageHeight ;

}