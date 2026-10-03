/**
 * @description 业务线实例关联审批流表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuApprove
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuApprove
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_approve")
// @ApiModel("业务线实例关联审批流表")
public class SignRuApprove extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5124908827631200613L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("'审批类型，1发起前审批，2签署前审批'")
    private Integer approveType ;

    // @ApiModelProperty("'审批序号'")
    private Integer approveOrder ;

    // @ApiModelProperty("'审批流id'")
    private String approveId ;

}