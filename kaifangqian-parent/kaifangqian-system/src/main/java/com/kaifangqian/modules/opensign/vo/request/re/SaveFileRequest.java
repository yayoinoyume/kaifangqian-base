package com.kaifangqian.modules.opensign.vo.request.re;

import com.kaifangqian.modules.opensign.vo.base.sign.DocFileVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SaveFileRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: SaveFileRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线签约文件保存-请求对象")
public class SaveFileRequest implements Serializable {

    private static final long serialVersionUID = -7770812828468939687L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("业务线签约文件")
    private DocFileVo fileVo ;


}