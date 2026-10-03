/**
 * @description 签署意愿校验主表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@TableName("sign_user_confirm")
// @ApiModel("签署意愿校验主表")
public class SignUserConfirm implements Serializable {

    private static final long serialVersionUID = -1964598393002371754L;

    // @ApiModelProperty("主键-订单号")
    private String id;
    /**
     * 关联数据ID
     */
    private String mainId;
    /**
     * 校验类型
     */
    private String confirmType;
    /**
     * 校验参数
     */
    private String confirmPara;
    /**
     * 最终校验结果
     */
    private Boolean finalConfirmFlag;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;

    /**
     * 更新用户
     */
    private String updateBy;
    /**
     * 更新日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;

}