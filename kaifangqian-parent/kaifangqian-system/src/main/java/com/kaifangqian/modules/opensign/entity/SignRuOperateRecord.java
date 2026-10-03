/**
 * @description 业务线实例-签署操作记录表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: SignRuOperateRecord
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuOperateRecord
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_operate_record")
// @ApiModel("业务线实例-签署操作记录表")
public class SignRuOperateRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -7628681531766655474L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("业务线实例主表id")
    private String signRuId ;

    // @ApiModelProperty("使用证书id")
    private String certId ;

    // @ApiModelProperty("签章图片文件id")
    private String imageAnnexId ;

    // @ApiModelProperty("签署意愿校验订单号")
    private String confirmOrderNo ;

    // @ApiModelProperty("签署意愿校验类型")
    private String confirmType ;

    // @ApiModelProperty("任务节点id")
    private String taskId ;

    // @ApiModelProperty("操作人账号id")
    private String accountId ;

    // @ApiModelProperty("操作人租户id")
    private String tenantId ;

    // @ApiModelProperty("操作人租户下用户ID")
    private String tenantUserId ;

//    // @ApiModelProperty("签署人类型")
//    private Integer signerType ;

    // @ApiModelProperty("操作类型")
    private String operateType ;

    // @ApiModelProperty("执行类型")
    private String actionType ;

    // @ApiModelProperty("操作时间")
    private Date operateTime ;

    // @ApiModelProperty("ip地址")
    private String ipAddr  ;

    // @ApiModelProperty("操作原因")
    private String operateReason ;


}