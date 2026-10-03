/**
 * @description 业务线实例-任务表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseAuthEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sign_ru_task")
// @ApiModel("业务线实例-任务表")
public class SignRuTask extends BaseAuthEntity implements Serializable {

    private static final long serialVersionUID = 3427159219338431715L;

    // @ApiModelProperty("'主键'")
    private String id;

    // @ApiModelProperty("'流程记录主表ID'")
    private String signRuId;

    // @ApiModelProperty("''节点类型''")
    private String taskType;

    // @ApiModelProperty("'节点关联类型:system,bind,register'")
    private String taskLinkType;

    // @ApiModelProperty("租户名称")
    private String tenantName;

    // @ApiModelProperty("''待执行人手机号''")
    private String phone;

    // @ApiModelProperty("''待执行人邮箱''")
    private String email;

    // @ApiModelProperty("待执行人类型：1发起人，2外部个人签署人，3外部企业签署人")
    private Integer userType;

    // @ApiModelProperty("对应表ID：内部流程配置节点表ID，实例-签约方对应表ID")
    private String userTaskId;

    // @ApiModelProperty("待执行人账户id")
    private String userId;

    // @ApiModelProperty("待执行人租户用户id")
    private String tenantUserId;

    // @ApiModelProperty("待执行人租户id")
    private String tenantId;

    // @ApiModelProperty("办理用户账户ID")
    private String completeUserId;

    // @ApiModelProperty("办理租户用户ID")
    private String completeTenantUserId;

    // @ApiModelProperty("办理租户ID")
    private String completeTenantId;

    // @ApiModelProperty("任务状态：1待办理，2已办理")
    private Integer taskStatus;

    // @ApiModelProperty("办理动作类型：approve,reject")
    private String checkMenuType;

    // @ApiModelProperty("办理意见")
    private String checkMessage;

    // @ApiModelProperty("办理日期")
    private Date checkTime;

    // @ApiModelProperty("云盾签署订单")
    private String orderNo;

    // @ApiModelProperty("云盾意愿校验签署地址")
    private String ydAuthSignUrl;

    private transient boolean sendMsgFlag;
}