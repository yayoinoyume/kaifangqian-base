/**
 * @description 文档签署图片记录
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
@TableName("sign_doc_image_record")
// @ApiModel("文档签署图片记录")
public class SignDocImageRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6526597812409385329L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("文档id")
    private String docId ;

    // @ApiModelProperty("文档操作记录id")
    private String docRecordId ;

    // @ApiModelProperty("签署文档页数")
    private Integer docPage ;

    // @ApiModelProperty("是否为最新签署的，1为是，2为否")
    private Integer isCurrent ;

    // @ApiModelProperty("文件id")
    private String annexId ;



}