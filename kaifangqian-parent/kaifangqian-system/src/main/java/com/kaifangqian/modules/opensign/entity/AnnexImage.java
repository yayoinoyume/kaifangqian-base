/**
 * @description 文件转换图片记录表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: AnnexImage
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("annex_image")
// @ApiModel("文件转换图片记录表")
public class AnnexImage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1964598393002371754L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("图片真实文件id")
    private String imageAnnexId ;

    // @ApiModelProperty("关联真实文件id")
    private String annexId ;

    // @ApiModelProperty("页码")
    private Integer page ;

    // @ApiModelProperty("图片宽")
    private String imageWidth ;

    // @ApiModelProperty("图片高")
    private String imageHeight ;

}