package com.kaifangqian.modules.opensign.vo.response.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: RuOperateRecordResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: RuOperateRecordResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
// @ApiModel("业务线实例-操作记录-返回数据")
public class RuOperateRecordResponse implements Serializable {

    private static final long serialVersionUID = 4445018654578690349L;

    // @ApiModelProperty("操作人名称")
    private String operatorName ;

    // @ApiModelProperty("操作类型")
    private String operateType ;

    // @ApiModelProperty("操作动作")
    private String actionType ;

    // @ApiModelProperty("操作时间")
    private String operateTime ;

    // @ApiModelProperty("操作说明")
    private String operateNotes ;

}