/**
 * @description 签署文档相关数据
 */
package com.kaifangqian.external.sign.request;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class DocumentInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    // @ApiModelProperty("文件ID")
    private String documentId;

    // @ApiModelProperty("文件名称")
    private String documentName;

    // @ApiModelProperty("文件摘要")
    private String documentHash;

    // @ApiModelProperty("签名数据")
    private String signature;


}
