package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: DocSubmitRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocSubmitRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档发布请求对象")
public class DocSubmitRequest implements Serializable {

    private static final long serialVersionUID = -8424072165818489352L;

    // @ApiModelProperty("主键")
    private String id;


}