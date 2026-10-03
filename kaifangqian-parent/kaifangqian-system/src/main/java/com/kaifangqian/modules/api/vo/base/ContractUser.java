/**
 * @description API接口合同操作人
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractUser
 * @Package: com.kaifangqian.modules.api.vo.base
 * @ClassName: ContractUser
 * @author: FengLai_Gong
 * @Date: 2024/03/19
 */
@Data
// @ApiModel("操作人")
public class ContractUser implements Serializable {

    private static final long serialVersionUID = 862003493609163515L;

//    @NotNull(message = "NotNull",groups = ValidationSorts.SortA1.class)
//    @NotBlank(message = "NotBlank",groups = ValidationSorts.SortA1.class)
    // @ApiModelProperty("姓名")
    private String name ;

    // @ApiModelProperty("联系类型")
    private String contactType ;

    // @ApiModelProperty("联系方式")
    private String contact ;

}