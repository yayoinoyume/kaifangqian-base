/**
 * @description 临时签约文件图片表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignReTemporaryImage
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignReTemporaryImage
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_temporary_image")
// @ApiModel("临时签约文件图片表")
public class SignReTemporaryImage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 879933486223334356L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("临时签约文件id")
    private String temporaryId ;

    // @ApiModelProperty("'页码'")
    private Integer page ;

    // @ApiModelProperty("'真实文件id'")
    private String annexId ;

}