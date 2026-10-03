/**
 * @description API接口合同签署附件信息
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: AnnexFileRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: AnnexFileRequest
 * @author: FengLai_Gong
 * @Date: 2024/5/17
 */
@Data
public class AnnexFileRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -4331183540997060322L;

    // @ApiModelProperty("签署文件的base64格式")
    private String file ;
    // @ApiModelProperty("文件名称")
    private String fileName ;
    // @ApiModelProperty("文件后缀，如 .pdf")
    private String fileSuffix ;
}