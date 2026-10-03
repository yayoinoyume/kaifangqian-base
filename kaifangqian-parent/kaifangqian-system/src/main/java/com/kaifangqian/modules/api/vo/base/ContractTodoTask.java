/**
 * @description API接口合同签署任务
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: Task
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: Task
 * @author: FengLai_Gong
 * @Date: 2024/03/19
 */
@Data
// @ApiModel("任务数据")
public class ContractTodoTask implements Serializable {

    private static final long serialVersionUID = -1029806526276072226L;

    // @ApiModelProperty("任务ID")
    private String taskId ;

    // @ApiModelProperty("任务类型：填写/签署")
    private String taskType ;

    // @ApiModelProperty("任务办理方类型：发起方，个人接收方，企业接收方")
    private String partyType ;

    // @ApiModelProperty("办理方名称，个人：个人姓名，企业：企业名称")
    private String partyName ;

    // @ApiModelProperty("办理人账号唯一标识，个人：个人账号唯一标识，企业：经办人唯一标识")
    private String partyAccount ;

    // @ApiModelProperty("办理人信息")
    private ContractUser party ;

//    // @ApiModelProperty("办理人姓名")
//    private String name ;

//    // @ApiModelProperty("办理人手机号")
//    private String mobile ;



}