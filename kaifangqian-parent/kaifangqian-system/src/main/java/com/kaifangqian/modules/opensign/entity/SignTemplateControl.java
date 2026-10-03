/**
 * @description 模板控件表Mapper
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignDocControl
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_control")
// @ApiModel("模板控件表")
public class SignTemplateControl extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 4002282005367263859L;

    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("印章所属系统租户id")
    private String sysTenantId ;

    // @ApiModelProperty("印章所属系统账号id")
    private String sysAccountId ;

    // @ApiModelProperty("印章所属系统租户下用户id")
    private String sysUserId ;

    // @ApiModelProperty("印章所属系统部门编码")
    private String sysOrgCode ;

    // @ApiModelProperty("印章所属系统部门id")
    private String sysDeptId ;

    // @ApiModelProperty("关联模板Id")
    private String templateId ;

    // @ApiModelProperty("控件类型（控件类型，1为签署，2为填写）")
    private String type ;

    // @ApiModelProperty("控件名称")
    private String name ;

    // @ApiModelProperty("控件X坐标(左上角)")
    private String offsetX ;

    // @ApiModelProperty("控件Y坐标(左上角)")
    private String offsetY ;

    // @ApiModelProperty("控件宽度")
    private String width ;

    // @ApiModelProperty("控件高度")
    private String height ;

    // @ApiModelProperty("控件所属页码")
    private Integer page ;

    // @ApiModelProperty("是否已经填充，1为已填充，2为未填写")
    private Integer isFilled;

    // @ApiModelProperty("是否为必填项，1为必填项，2为非必填项")
    private Integer isRequired;

    // @ApiModelProperty("文字字体")
    private String fontFamily ;

    // @ApiModelProperty("对其方式")
    private String textAlign ;

    // @ApiModelProperty("文字大小")
    private Integer fontSize ;

    // @ApiModelProperty("提示值")
    private String placeholder ;

    // @ApiModelProperty("填写值")
    private String value ;

    // @ApiModelProperty("解析格式")
    private String format ;

    // @ApiModelProperty("当前文件页面宽度")
    private String pageWidth ;

    // @ApiModelProperty("当前文件页面高度")
    private String pageHeight ;

    // @ApiModelProperty("接口参数名称")
    private String interfaceParamName ;


    // @ApiModelProperty("控件属性")
    private String properties;

    // @ApiModelProperty("顺序")
    private Integer controlOrder;



}