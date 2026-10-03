package com.kaifangqian.modules.opensign.vo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: OperateListResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: OperateListResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模版操作记录-返回对象")
public class ApplyListResponse implements Serializable {

    private static final long serialVersionUID = -3820442876877111513L;

    // @ApiModelProperty("主键")
    private String templateApplyId;

    // @ApiModelProperty("模板id")
    private String templateId ;


    // @ApiModelProperty("申请人租住用户id")
    private String sysTenantUserId ;


    // @ApiModelProperty("申请人租住用户名称")
    private String sysTenantUserName ;

    // @ApiModelProperty("操作类型")
    private Integer operateType ;

    // @ApiModelProperty("操作类型名称")
    private String operateName ;


    // @ApiModelProperty("申请时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime ;

    // @ApiModelProperty("申请状态（1、待提交，2、待重新提交，3、待审批，4、审批未通过，5、审批通过，6、作废）")
    private Integer applyStatus ;

    // @ApiModelProperty("申请状态名称（1、待提交，2、待重新提交，3、待审批，4、审批未通过，5、审批通过，6、作废）")
    private String applyName ;







}