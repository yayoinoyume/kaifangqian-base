package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocImageConvertRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocImageConvertRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档文件转图片请求对象")
public class DocImageConvertRequest implements Serializable {

    private static final long serialVersionUID = -2451699967703428224L;

    // @ApiModelProperty("文档id")
    private String docId ;
    // @ApiModelProperty("文档主文件id")
    private String annexId ;
}