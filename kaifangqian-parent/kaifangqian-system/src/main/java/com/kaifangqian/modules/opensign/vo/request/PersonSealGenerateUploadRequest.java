package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealGenerateUploadRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: EntSealGenerateUploadRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("签名生成-上传生成-请求对象")
public class PersonSealGenerateUploadRequest implements Serializable {

    private static final long serialVersionUID = -2419487055423681196L;

    // @ApiModelProperty("图片base64")
    private String image ;


}