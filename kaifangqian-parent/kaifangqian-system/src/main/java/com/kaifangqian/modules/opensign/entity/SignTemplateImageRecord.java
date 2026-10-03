/**
 * @description 模板操作图片记录
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignDocImageRecord
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignDocImageRecord
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_image_record")
// @ApiModel("模板操作图片记录")
public class SignTemplateImageRecord extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -3010246375526776893L;
    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("关联文档ID")
    private String templateId ;

    // @ApiModelProperty("签署记录id")
    private String templateRecordId ;

    // @ApiModelProperty("签署文档页数")
    private Integer templatePage ;

    // @ApiModelProperty("是否为最新签署的，1为是，2为否")
    private Integer isCurrent ;

    // @ApiModelProperty("文件id")
    private String annexId ;

}