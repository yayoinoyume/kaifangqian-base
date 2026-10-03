/**
 * @description 合同签署任务状态响应类
 */
package com.kaifangqian.modules.api.vo.response;

import com.kaifangqian.modules.api.vo.base.ContractTodoTask;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ContractTasksResponse
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: ContractTasksResponse
 * @author: FengLai_Gong
 */
@Data
public class ContractTasksResponse implements Serializable {

    private static final long serialVersionUID = -8787772895674278862L;

    // @ApiModelProperty("合同状态")
    private String status ;

    // @ApiModelProperty("待办任务列表")
    private List<ContractTodoTask> todoTaskList ;


}