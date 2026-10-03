/**
 * @description 业务线实例主表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.common.base.entity.BaseAuthEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 业务线实例主表
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRu
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru")
// @ApiModel("业务线实例主表")
public class SignRu extends BaseAuthEntity implements Serializable {

    private static final long serialVersionUID = 3427159219338431715L;

    // @ApiModelProperty("'主键'")
    private String id;

    // @ApiModelProperty("''业务线ID''")
    private String signReId;

    // @ApiModelProperty("''文件编号''")
    private String code;

    // @ApiModelProperty("'文件主题'")
    private String subject;

    // @ApiModelProperty("'签署截止时间'")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireDate;

    // @ApiModelProperty("签署人类型，1自定义、2预设流程")
    private Integer signerType;

    // @ApiModelProperty("签署顺序类型，1有序签署、2无序签署")
    private Integer signOrderType;

    // @ApiModelProperty("是否抄送，1为是，2为否")
    private Integer ccedType;

    // @ApiModelProperty("'抄送时机，1为文件发起时，2为文件签署完成时'")
    private Integer ccedOpportunityType;

    // @ApiModelProperty("'是否支持内部抄送，1为是，2为否'")
    private Integer internalCcerType;

    // @ApiModelProperty("'是否支持外部抄送，1为是，2为否'")
    private Integer externalCcerType;

    // @ApiModelProperty("'是否允许添加抄送人，1为是，2为否'")
    private Integer addCcerType;

    // @ApiModelProperty("'是否允许添加签约文件，1为是，2为否'")
    private Integer addFileType;

    // @ApiModelProperty("'是否允许删除签约文件，1为是，2为否'")
    private Integer deleteFileType;

    // @ApiModelProperty("'是否允许添加附件，1为是，2为否'")
    private Integer addAnnexType;

    // @ApiModelProperty("'使用证书签署方式，1使用ca证书，2使用防篡改证书，3不使用证书'")
    private Integer caSignType;

    // @ApiModelProperty("'发起前是否有审批，1为是，2为否'")
    private Integer beforeStartApproveType;

    // @ApiModelProperty("'发起前审批流程id'")
    private String beforeStartApproveId;

    // @ApiModelProperty("'签署前是否有审批，1为是，2为否'")
    private Integer beforeSignApproveType;

    // @ApiModelProperty("'签署前审批流程id'")
    private String beforeSignApproveId;

    // @ApiModelProperty("'异常状态，1为是，2为否'")
    private Integer errorStatus;

    // @ApiModelProperty("状态'")
    private Integer status;

    // @ApiModelProperty("发起时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    // @ApiModelProperty("结束时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    // @ApiModelProperty("控件变更状态")
    private String controlChangeFlag ;

    //value字段值为：required（须实名认证）、allowed（允许不实名认证）、not_required（无需实名认证）
    private String personalSignAuth ;

    //发起类型：api(接口发起)；app（应用发起）
    private String sendType;

    //签署实例结束类型：0:手动结束；1:自动结束；
    private Integer autoFinish;


}