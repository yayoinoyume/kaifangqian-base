package com.kaifangqian.modules.opensign.vo.request.re;

import com.kaifangqian.modules.opensign.vo.base.sign.DocSignerVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SaveSignerRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: SaveSignerRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线签署人保存-请求对象")
public class SaveSignerRequest implements Serializable {

    private static final long serialVersionUID = 352372719146170859L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("签署人列表数据")
    private List<DocSignerVo> signerList ;
}