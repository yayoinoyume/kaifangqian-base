/**
 * @description 业务线配置-签约文件表
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
@TableName("sign_re_doc")
// @ApiModel("业务线配置-签约文件表")
public class SignReDoc extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 2391830833392852217L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("'文档类型，1上传，2模版'")
    private Integer docType ;

    // @ApiModelProperty("'签约文档来源id'")
    private String docOriginId ;

    // @ApiModelProperty("''签约文件名称''")
    private String docName ;

    // @ApiModelProperty("'真实文件id'")
    private String annexId ;


    // @ApiModelProperty("文件页数")
    private Integer docPage ;

    // @ApiModelProperty("签约文件顺序")
    private Integer docOrder ;

}