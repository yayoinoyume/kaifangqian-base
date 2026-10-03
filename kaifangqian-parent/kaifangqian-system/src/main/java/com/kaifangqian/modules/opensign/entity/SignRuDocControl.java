/**
 * @description 业务线实例-签署人控件配置表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuDocControl
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_doc_control")
// @ApiModel("业务线实例-签署人控件配置表")
public class SignRuDocControl extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1831666496155386063L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("'业务线实例签约文件id'")
    private String signRuDocId ;

    // @ApiModelProperty("'人员类型，1发起方，2接收方'")
    private Integer signerType ;

    // @ApiModelProperty("'签署方id，signerId或者senderId'")
    private String signerId ;

    // @ApiModelProperty("'控件类型'")
    private String controlType ;

    // @ApiModelProperty("''异常状态，1为是，2为否''")
    private Integer errorStatus ;

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

    // @ApiModelProperty("来源类型，1、业务线，2、发起时设置、3、操作时设置")
    private Integer originType ;

    // @ApiModelProperty("填写控件属性")
    private String properties ;

    // @ApiModelProperty("顺序")
    private Integer controlOrder;

    // @ApiModelProperty("位置position、关键字keyword")
    private String setupType ;

    // @ApiModelProperty("关键字设置表id")
    private String setupId ;

}