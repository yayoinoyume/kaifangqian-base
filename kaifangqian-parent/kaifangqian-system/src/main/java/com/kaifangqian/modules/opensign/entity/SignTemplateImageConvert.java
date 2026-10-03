/**
 * @description 模板文件图片转换临时记录表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: SignDocImageRecord
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignDocImageRecord
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_image_convert")
// @ApiModel("模板文件图片转换临时记录表")
public class SignTemplateImageConvert implements Serializable {

    private static final long serialVersionUID = -1649246103996800960L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("文档id")
    private String templateId ;

    // @ApiModelProperty("文件id")
    private String annexId ;

    // @ApiModelProperty("签署文档页数")
    private Integer page ;

    // @ApiModelProperty("印章所属系统租户id")
    private String sysTenantId ;

    // @ApiModelProperty("印章所属系统账号id")
    private String sysAccountId ;

    // @ApiModelProperty("印章所属系统租户下用户id")
    private String sysUserId ;

    // @ApiModelProperty("创建人")
    private String createBy;

    // @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // @ApiModelProperty("删除标志：0未删除，1已删除")
    private Boolean deleteFlag;

    // @ApiModelProperty("删除人")
    private String deleteBy;

    // @ApiModelProperty("删除时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteTime;



}