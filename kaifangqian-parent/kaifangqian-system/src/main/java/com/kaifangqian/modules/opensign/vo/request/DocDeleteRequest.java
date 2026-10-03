package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocDeleteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocDeleteRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档删除请求对象")
public class DocDeleteRequest implements Serializable {

    private static final long serialVersionUID = 1158200299886898548L;

    // @ApiModelProperty("文档id")
    private String docId ;


}