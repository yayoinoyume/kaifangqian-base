/**
 * @description 图片数据
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

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
public class SignImageVo implements Serializable {

    private static final long serialVersionUID = -6632885753877943173L;

    // @ApiModelProperty("图片数据id")
    private String id ;

    // @ApiModelProperty("关联文件id")
    private String annexId;

    // @ApiModelProperty("页码")
    private Integer page ;

}