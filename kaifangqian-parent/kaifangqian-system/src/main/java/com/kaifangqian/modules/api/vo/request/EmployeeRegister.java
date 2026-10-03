/**
 * @description 员工注册对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.validation.ValidationSorts;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author : zhenghuihan
 * create at:  2024/3/22  14:20
 * @description: 企业员工注册
 */
@Data
public class EmployeeRegister extends ReqBaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String account;

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
}