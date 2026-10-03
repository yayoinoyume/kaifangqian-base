package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: PersonSealSaveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: PersonSealSaveRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("个人签名新增请求对象")
public class PersonSealSaveRequest implements Serializable {


    private static final long serialVersionUID = 69518285727335464L;
    // @ApiModelProperty("签名名称")
    private String sealName ;

    // @ApiModelProperty("文件id")
    private String annexId;

    // @ApiModelProperty("印章生成类型：TEMPLATE：模板生成、HAND：手写签名")
    private String sealType ;

}