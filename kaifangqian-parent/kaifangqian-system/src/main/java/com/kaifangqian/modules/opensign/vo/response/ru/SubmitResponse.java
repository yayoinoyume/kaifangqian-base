package com.kaifangqian.modules.opensign.vo.response.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: SubmitResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: SubmitResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
// @ApiModel("业务线实例-提交填写、签署-返回数据")
public class SubmitResponse implements Serializable {

    // @ApiModelProperty("业务线实例id")
    private String ruId ;
    // @ApiModelProperty("任务id")
    private String taskId ;
    // @ApiModelProperty("任务类型")
    private String taskType ;
}