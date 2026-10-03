/**
 * @description 签署意愿校验子表
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
@TableName("sign_user_confirm_step")
// @ApiModel("签署意愿校验子表")
public class SignUserConfirmStep implements Serializable {

    private static final long serialVersionUID = -1964598393002371754L;

    // @ApiModelProperty("主键")
    private String id;
    /**
     * 校验主表ID
     */
    private String confirmId;
    /**
     * 校验步骤
     */
    private Integer step;
    /**
     * 校验类型
     */
    private String confirmType;
    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 系统参数
     */
    private String systemPara;
    /**
     * 用户提交参数
     */
    private String userPara;

    /**
     * 校验结果
     */
    private Boolean confirmFlag;

    private Integer bindDataFlag;
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

    // @ApiModelProperty("删除标志：0未删除，1已删除")
    private Boolean deleteFlag;

}