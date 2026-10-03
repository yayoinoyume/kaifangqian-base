/**
 * @description 企业注册对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.validation.ValidationSorts;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author : zhenghuihan
 * create at:  2024/3/22  14:20
 * @description: 企业注册
 */
@Data
public class EnterpriseRegister extends ReqBaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String account;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String contactType;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String enterpriseName;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String employeeAccount;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String name;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    @Length(min = 11, max = 11, message = "23000", groups = ValidationSorts.SortC3.class)
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "23001", groups = ValidationSorts.SortC4.class)
    private String mobile;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String email;

    // @ApiModelProperty("企业证件号，多证合一后建议传递统一社会信用代码")
    private String creditCode ;

    // @ApiModelProperty("法人姓名")
    private String legalPerson ;

    // @ApiModelProperty("法人证件号(身份证号)")
    private String identity ;

    // @ApiModelProperty("是否为企业自动生成印章，0：否，1：是,不传递，默认不生成印章")
    private Integer isMakeSeal ;
}