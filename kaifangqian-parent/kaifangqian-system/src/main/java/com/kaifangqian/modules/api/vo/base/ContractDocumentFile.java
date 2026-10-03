/**
 * @description API接口合同文件对象
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocumentFileResponse
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: DocumentFileResponse
 * @author: FengLai_Gong
 * @Date: 2024/5/10
 */
@Data
// @ApiModel("签约文件")
public class ContractDocumentFile implements Serializable {

    private static final long serialVersionUID = -4270464904587543259L;

    // @ApiModelProperty("签约文件id")
    private String docId ;
}