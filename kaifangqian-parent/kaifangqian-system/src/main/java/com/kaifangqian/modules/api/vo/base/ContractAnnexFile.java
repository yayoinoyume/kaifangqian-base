/**
 * @description API接口合同附件对象
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: AnnexFileResponse
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: AnnexFileResponse
 * @author: FengLai_Gong
 * @Date: 2024/5/27
 */
@Data
// @ApiModel("附件")
public class ContractAnnexFile implements Serializable {

    private static final long serialVersionUID = 5439930068526780589L;


    // @ApiModelProperty("附件id")
    private String fileId ;
}