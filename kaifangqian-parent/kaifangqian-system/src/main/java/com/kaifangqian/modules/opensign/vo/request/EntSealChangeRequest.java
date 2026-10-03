package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealSaveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: EntSealSaveRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("印章新增请求对象")
public class EntSealChangeRequest implements Serializable {


    private static final long serialVersionUID = -262548305395622229L;


    // @ApiModelProperty("企业签章申请记录id")
    private String sealApplyId;

    // @ApiModelProperty("企业签章id")
    private String sealId ;

    // @ApiModelProperty("创建类型（1、模板创建；2、上传创建）")
    private Integer createType ;

    // @ApiModelProperty("印章样式（1、公章；2、圆形章；3、椭圆形；）")
    private Integer sealStyle ;

    // @ApiModelProperty("颜色(1、红色；2、蓝色；3、黑色)")
    private Integer color ;

    // @ApiModelProperty("上排环绕文字")
    private String topText ;

    // @ApiModelProperty("横排文字',")
    private String middleText ;

    // @ApiModelProperty("下弦文")
    private String bottomText ;

    // @ApiModelProperty("文件id")
    private String annexId;



    // @ApiModelProperty("签章图片base64")
    private String sealBase64;




}