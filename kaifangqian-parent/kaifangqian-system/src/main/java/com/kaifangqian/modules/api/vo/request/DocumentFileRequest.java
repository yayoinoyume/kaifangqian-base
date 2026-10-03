/**
 * @description API接口合同签署文件对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.validation.ValidationSorts;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: DocumentFileRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: DocumentFileRequest
 * @author: FengLai_Gong
 * @Date: 2025/3/27
 */
@Data
public class DocumentFileRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = 7438239524766497990L;

    // @ApiModelProperty("签署文件的base64格式")
    private String file ;


    // @ApiModelProperty("文件名称")
    @NotNull(message = "21000", groups = ValidationSorts.SortA1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortA1.class)
    private String fileName ;


    // @ApiModelProperty("文件后缀，如 .pdf")
    private String fileSuffix ;


}