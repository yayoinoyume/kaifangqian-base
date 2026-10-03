package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocRevokeRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocRevokeRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档撤回请求对象")
public class DocRevokeRequest implements Serializable {

    private static final long serialVersionUID = -7547014967024261364L;
    // @ApiModelProperty("文档id")
    private String docId ;
}