/**
 * @description 业务线实例-签约文件表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuApprove
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuApprove
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_doc")
// @ApiModel("业务线实例-签约文件表")
public class SignRuDoc extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 6413480086875173025L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;


    // @ApiModelProperty("'文档类型，1上传，2模版'")
    private Integer docType ;


    // @ApiModelProperty("'签约文档来源id'")
    private String docOriginId ;

    // @ApiModelProperty("''签约文件名称''")
    private String docName ;

    // @ApiModelProperty("来源类型，1、业务线，2、自行上传")
    private Integer originType ;

    // @ApiModelProperty("文件页数")
    private Integer docPage ;

    // @ApiModelProperty("签约文件顺序")
    private Integer docOrder ;

}