/**
 * @description 业务线实例-签约文件操作记录表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuDocImage
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_doc_operate")
// @ApiModel("业务线实例-签约文件操作记录表")
public class SignRuDocOperate extends BaseEntity implements Serializable {


    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("'签约文件主表id'")
    private String docId ;

//    // @ApiModelProperty("'签约文件操作记录表id'")
//    private String docOperateId ;

    // @ApiModelProperty("'是否为最新文件，1为是，2为否'")
    private Integer isCurrent ;

    // @ApiModelProperty("'真实文件id'")
    private String annexId ;


}