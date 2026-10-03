package com.kaifangqian.modules.opensign.vo.request.re;

import com.kaifangqian.modules.opensign.vo.base.sign.DocCcerVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SaveCcerRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: SaveCcerRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线抄送人数据保存-请求对象")
public class SaveCcerRequest implements Serializable {

    private static final long serialVersionUID = -6844956737272720249L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("抄送人列表")
    private List<DocCcerVo> ccerList ;


}