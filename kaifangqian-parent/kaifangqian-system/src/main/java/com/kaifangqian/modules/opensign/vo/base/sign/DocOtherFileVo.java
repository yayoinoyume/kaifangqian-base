/**
 * @description 签约文件-附件数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocFileVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocFileVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("签约文件-附件数据对象")
public class DocOtherFileVo implements Serializable {

    private static final long serialVersionUID = -5799656589362270699L;

    // @ApiModelProperty("签约文件附件名称")
    private String realName ;

    // @ApiModelProperty("签约文件附件真实文件id")
    private String annexId ;

    // @ApiModelProperty("签约文件附件真实文件id")
    private String id ;

}