/**
 * @description 文件转图片返回对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocImageConvertResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: DocImageConvertResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文件转图片返回对象")
public class ImageConvertVo implements Serializable {

    private static final long serialVersionUID = 9155925908067115853L;

    // @ApiModelProperty("图片文件id")
    private String imageAnnexId ;
    // @ApiModelProperty("页码")
    private Integer page ;

    // @ApiModelProperty("图片数据")
    private byte[] imageByte ;

    // @ApiModelProperty("图片宽")
    private String imageWidth ;

    // @ApiModelProperty("图片高")
    private String imageHeight ;


}