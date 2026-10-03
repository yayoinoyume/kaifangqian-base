package com.kaifangqian.modules.opensign.vo.request.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.DocBaseVo;
import com.kaifangqian.modules.opensign.vo.base.sign.DocCcerVo;
import com.kaifangqian.modules.opensign.vo.base.sign.DocSignerVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SaveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: SaveRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线实例保存草稿-请求对象")
public class StartSaveBaseRequest implements Serializable {

    private static final long serialVersionUID = -7554751196381989275L;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("业务线主数据")
    private DocBaseVo baseVo ;

    // @ApiModelProperty("签约方列表数据")
    private List<DocSignerVo> signerList ;

    // @ApiModelProperty("抄送方列表数据")
    private List<DocCcerVo> ccerList ;


}

