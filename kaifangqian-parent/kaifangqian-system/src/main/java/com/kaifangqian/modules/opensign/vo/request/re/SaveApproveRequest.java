package com.kaifangqian.modules.opensign.vo.request.re;

import com.kaifangqian.modules.opensign.vo.base.sign.DocApproveVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SaveApproveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: SaveApproveRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线权限设置保存-请求对象")
public class SaveApproveRequest implements Serializable {

    private static final long serialVersionUID = -6424737043530460691L;

    // @ApiModelProperty("权限数据列表")
    private List<DocApproveVo> approveList ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;


}