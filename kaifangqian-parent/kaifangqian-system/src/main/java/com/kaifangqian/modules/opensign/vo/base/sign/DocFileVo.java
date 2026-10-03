/**
 * @description 签约文件数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: DocFileVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocFileVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("签约文件数据对象")
public class DocFileVo implements Serializable {

    private static final long serialVersionUID = -5799656589362270699L;

    // @ApiModelProperty("签约文件id")
    private String id ;

    // @ApiModelProperty("签约文件名称")
    private String name ;

    // @ApiModelProperty("签约文件类型，1、上传、2模板")
    private Integer docType ;

    // @ApiModelProperty("签约文件来源id")
    private String docOriginId ;

    // @ApiModelProperty("签约文件真实文件id")
    private String annexId ;

//    // @ApiModelProperty("图片列表")
//    private List<DocImageVo> imageList ;

    // @ApiModelProperty("来源类型，1、业务线，2、自行上传")
    private Integer originType ;

    // @ApiModelProperty("来源类型，1、有参数；2、无参数")
    private Integer paramType ;

    // @ApiModelProperty("文件页数")
    private Integer docPage ;

    // @ApiModelProperty("签约文件顺序")
    private Integer docOrder ;

}