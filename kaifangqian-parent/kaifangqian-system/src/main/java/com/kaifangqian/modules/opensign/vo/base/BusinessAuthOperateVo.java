/**
 * @description 业务权限操作对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: BusinessAuthOperateVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: BusinessAuthOperateVo
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务权限操作对象")
public class BusinessAuthOperateVo implements Serializable {

    // @ApiModelProperty("操作权限编码")
    private Integer operateCode ;

    // @ApiModelProperty("操作权限名称")
    private String operateName ;



}