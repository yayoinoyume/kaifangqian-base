/**
 * @description 业务线实例-实例关联人表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRurelation
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRurelation
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_relation")
// @ApiModel("业务线实例-实例关联人表")
public class SignRuRelation extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 873174720695070012L;

    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("关联类型,1发起人，2抄送人")
    private Integer relationType;

    // @ApiModelProperty("租户下用户id，发起人id，抄送人id")
    private String tenantUserId;

    // @ApiModelProperty("'节点关联类型:system,bind,register'")
    private String taskLinkType;

    // @ApiModelProperty("'外部抄送人抄送类型，1手机号，2邮箱号'")
    private Integer externalCcedType;

    // @ApiModelProperty("'外部抄送人抄送值'")
    private String externalCcedValue;

    // @ApiModelProperty("'抄送人类型，1内部，2外部'")
    private transient Integer ccerType ;
}