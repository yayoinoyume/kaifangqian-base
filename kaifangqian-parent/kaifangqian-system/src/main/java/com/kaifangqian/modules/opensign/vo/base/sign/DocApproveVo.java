/**
 * @description 业务线审批数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocApproveVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocApproveVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线审批数据对象")
public class DocApproveVo implements Serializable {

    private static final long serialVersionUID = 4714597774322109009L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("'审批类型，1发起前审批，2签署前审批'")
    private Integer approveType ;

    // @ApiModelProperty("'审批序号'")
    private Integer approveOrder ;

    // @ApiModelProperty("'审批流id'")
    private String approveId ;
}