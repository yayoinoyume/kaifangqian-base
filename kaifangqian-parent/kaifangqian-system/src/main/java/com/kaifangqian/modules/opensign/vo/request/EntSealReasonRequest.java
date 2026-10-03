package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealEnabled
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: EntSealEnabled
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("印章状态修改原因-请求对象")
public class EntSealReasonRequest implements Serializable {

    private static final long serialVersionUID = 6345480332061395183L;

    // @ApiModelProperty("企业签章申请记录id")
    private String sealApplyId;

    // @ApiModelProperty("申请原因")
    private String description;
}