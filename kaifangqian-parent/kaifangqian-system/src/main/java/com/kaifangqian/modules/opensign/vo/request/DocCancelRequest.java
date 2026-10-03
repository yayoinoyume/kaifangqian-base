package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocCancelRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocCancelRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档作废请求对象")
public class DocCancelRequest implements Serializable {

    private static final long serialVersionUID = 9102046185854892578L;

    // @ApiModelProperty("文档id")
    private String docId ;


}