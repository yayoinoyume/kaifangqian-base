/**
 * @description 意愿校验签署请求参数
 */
package com.kaifangqian.external.sign.request;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class VerifySignDocumentRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    // @ApiModelProperty("订单号")
    private String orderNo;

    // @ApiModelProperty("文档列表")
    private List<DocumentInfo> documents;

    // @ApiModelProperty("签章")
    private String seal;
}
