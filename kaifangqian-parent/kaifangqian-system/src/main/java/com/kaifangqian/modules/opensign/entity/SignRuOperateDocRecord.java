/**
 * @description 业务线实例-签署操作文件记录表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuOperateDocRecord
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuOperateDocRecord
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_operate_doc_record")
// @ApiModel("业务线实例-签署操作文件记录表")
public class SignRuOperateDocRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -504399301039175150L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("签署操作记录表id")
    private String operateRecordId ;

    // @ApiModelProperty("文档ID")
    private String docId ;

    // @ApiModelProperty("上次签约文件记录表id")
    private String previousDocOperateId ;

    // @ApiModelProperty("上次签约文件id")
    private String previousDocOperateAnnexId ;

    // @ApiModelProperty("本次签约文件记录表id")
    private String currentDocOperateId ;

    // @ApiModelProperty("本次签约文件id")
    private String currentDocOperateAnnexId ;




}