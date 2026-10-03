/**
 * @description 业务线实例-操作人（包括所有签约方、填写方）
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: SignRuDocImage
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_operator")
// @ApiModel("业务线实例-操作人（包括所有签约方、填写方）")
public class SignRuOperator extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -3708398586642617740L;

    // @ApiModelProperty("'主键'")
    private String id;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId;

    // @ApiModelProperty("'操作类型，1填写，2签署'")
    private Integer operateType;

    // @ApiModelProperty("'签署方类型，1发起方，2个人接收方，3企业接收方'")
    private Integer signerType;

    // @ApiModelProperty("'签署方id，signerId或者senderId'")
    private String signerId;

    // @ApiModelProperty("'序号'")
    private Integer operateOrder;

    // @ApiModelProperty("'操作人名称'")
    private String operateName;

    // @ApiModelProperty("'租户名称'")
    private String tenantName;

    // @ApiModelProperty("'外部签署人类型，1手机号，2邮箱号'")
    private Integer operateExternalType;

    // @ApiModelProperty("'外部签署人接受值'")
    private String operateExternalValue;

    // @ApiModelProperty("'操作人id，租户下用户id'")
    private String operateUserId;

    // @ApiModelProperty("'操作状态，0:不需要, 1:未完成，2:待完成 3：已完成 4:已拒绝'")
    private Integer operateStatus;

    // @ApiModelProperty("'操作时间'")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;


    private transient List<Integer> signerTypes;
}