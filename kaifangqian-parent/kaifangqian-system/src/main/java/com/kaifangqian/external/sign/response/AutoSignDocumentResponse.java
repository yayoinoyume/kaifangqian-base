/**
 * @description 静默签署响应对象
 */
package com.kaifangqian.external.sign.response;

import com.kaifangqian.external.sign.request.DocumentInfo;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class AutoSignDocumentResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    // @ApiModelProperty("文档列表")
    private List<DocumentInfo> documents;

    // @ApiModelProperty("签署类型")
    private Integer signType;

    // @ApiModelProperty("签署状态1：成功；2失败")
    private Integer status;

    // @ApiModelProperty("个人签署实名授权类型")
    private String personalSignAuth;

    // @ApiModelProperty("返回信息")
    private String resultMessage;

    // @ApiModelProperty("签署订单号")
    private String signOrderNo;
}
