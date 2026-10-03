/**
 * @description 云盾静默签署服务请求参数
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
public class AutoSignDocumentRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    // @ApiModelProperty("签署人租户ID")
    private String unionId;

    // @ApiModelProperty("合同号")
    private String contractNo;

    // @ApiModelProperty("合同名称")
    private String contractName;

    // @ApiModelProperty("文档列表")
    private List<DocumentInfo> documents;

    // @ApiModelProperty("签章")
    private String seal;

    // @ApiModelProperty("个人签署认证类型")
    private String personalSignAuth;

    // @ApiModelProperty("签署任务ID")
    private String bizId;
}
