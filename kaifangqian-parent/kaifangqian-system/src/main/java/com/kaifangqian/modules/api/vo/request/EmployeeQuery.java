/**
 * @description 员工查询对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.validation.ValidationSorts;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author : zhenghuihan
 * create at:  2024/3/22  14:20
 * @description: 企业员工查询
 */
@Data
public class EmployeeQuery extends ReqBaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "21000", groups = ValidationSorts.SortC1.class)
    @NotBlank(message = "22000", groups = ValidationSorts.SortC2.class)
    private String account;
}