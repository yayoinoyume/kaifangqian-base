/**
 * @description 用印明细返回对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @Description: UseSealDetailVo
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: UseSealDetailVo
 * @author: Fusion
 * CreateTime:  2023/8/18  14:50
 * @copyright 资助审批电子签章系统
 */
// @ApiModel("用印明细返回对象")
@Data
public class UseSealDetailVo {

    // @ApiModelProperty(value = "用印部门")
    private String useSealDept;     //用印部门

    // @ApiModelProperty(value = "业务类型")
    private String businessType;    //业务类型

    // @ApiModelProperty(value = "用印方式")
    private String useSealWay;      //用印方式

    // @ApiModelProperty(value = "加盖印章类型")
    private String sceneType;       //加盖印章类型

    // @ApiModelProperty(value = "印章类型")
    private String sealType;        //印章类型

    // @ApiModelProperty(value = "用印次数")
    private Integer useSealCount;     //用印次数
}
