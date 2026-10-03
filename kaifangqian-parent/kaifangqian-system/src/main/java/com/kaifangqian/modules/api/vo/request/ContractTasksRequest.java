/**
 * @description API接口合同签署任务对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractTasksRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractTasksRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/29
 */
@Data
public class ContractTasksRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -6606554942272591287L;

    // @ApiModelProperty("合同id")
    private String contractId ;

}