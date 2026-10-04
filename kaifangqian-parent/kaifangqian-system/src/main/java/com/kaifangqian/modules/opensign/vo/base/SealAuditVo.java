/**
 * @description 印章审计返回对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: SealAuditVo
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: SealAuditVo
 * @author: Fusion
 * CreateTime:  2023/8/18  14:50
 * @copyright 资助审批电子签章系统
 */
@Data
// @ApiModel("印章审计返回对象")
public class SealAuditVo {

    // @ApiModelProperty(value = "印章名称")
    private String sealName;                //印章名称

    // @ApiModelProperty(value = "印章类型")
    private String sealType;                //印章类型

    // @ApiModelProperty(value = "制作（新制）完成时间")
    private String createTime;             //制作（新制）完成时间

    // @ApiModelProperty(value = "变更数量")
    private Integer changeCount;           //变更数量

    // @ApiModelProperty(value = "停用数量")
    private Integer stopCount;             //停用数量

    // @ApiModelProperty(value = "激活数量")
    private Integer activateCount;         //激活数量

    // @ApiModelProperty(value = "收缴数量")
    private Integer collectionCount;       //收缴数量

    // @ApiModelProperty(value = "激活数量")
    private Integer destructionCount;      //激活数量

    // @ApiModelProperty(value = "当前状态")
    private String sealStatus;              //当前状态

}
