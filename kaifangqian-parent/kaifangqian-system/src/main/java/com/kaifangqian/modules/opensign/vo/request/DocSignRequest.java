package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocSignRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocSignRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档签署请求对象")
public class DocSignRequest implements Serializable {

    private static final long serialVersionUID = 1862735548843313167L;

    // @ApiModelProperty("文档id")
    private String docId ;
}