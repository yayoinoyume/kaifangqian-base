/**
 * @description 业务线配置-填写参数对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocParamVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocParamVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线配置-填写参数对象")
public class DocParamVo implements Serializable {

    private static final long serialVersionUID = -352142536984302186L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;


    // @ApiModelProperty("'业务线配置-签约文件id'")
    private String signReDocId ;



    // @ApiModelProperty("'人员类型，1发起方，2接收方'")
    private Integer signerType ;

    // @ApiModelProperty("'签署方id，signerId或者senderId'")
    private String signerId ;

    // @ApiModelProperty("'接口参数名称'")
    private String interfaceParamName ;


}