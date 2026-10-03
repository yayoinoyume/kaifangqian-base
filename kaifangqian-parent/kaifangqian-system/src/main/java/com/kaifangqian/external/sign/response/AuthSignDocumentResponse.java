/**
 * @description 意愿认证签署响应对象
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
public class AuthSignDocumentResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    // @ApiModelProperty("订单号")
    private String orderNo;

    // @ApiModelProperty("文档列表")
    private List<DocumentInfo> documents;

    // @ApiModelProperty("签署状态1：成功；0：失败")
    private Integer status;

    // @ApiModelProperty("签署类型")
    private Integer signType;

    /**
     * 个人签署实名要求
     */
    private String personalSignAuth;

    /**
     * 签署认证类型
     */
    private Integer authType;

    // @ApiModelProperty("返回信息")
    private String resultMessage;
}