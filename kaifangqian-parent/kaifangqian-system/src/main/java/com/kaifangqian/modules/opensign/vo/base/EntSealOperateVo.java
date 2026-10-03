/**
 * @description 企业印章操作返回对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealOperateVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: EntSealOperateVo
 * @author: FengLai_Gong
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("企业印章操作返回对象")
public class EntSealOperateVo implements Serializable {

    private static final long serialVersionUID = -8297308704158604237L;

    // @ApiModelProperty("企业签章申请记录id")
    private String sealApplyId;

    // @ApiModelProperty("企业签章id")
    private String sealId;
}