/**
 * @description 签署校验参数
 */
package com.kaifangqian.modules.opensign.dto;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : zhenghuihan
 * create at:  2024/5/29  14:50
 * @description:
 */
@Data
public class ReportUserConfirmInfo {
    // @ApiModelProperty(value = "校验类型")
    private String confirmType;
    // @ApiModelProperty(value = "签署校验时间")
    private Date confirmTime;
    // @ApiModelProperty(value = "签署校验信息")
    private String confirmInfo;

    // @ApiModelProperty(value = "人脸识别校验通道")
    private String faceChannel;
    // @ApiModelProperty(value = "活体检测分数")
    private String liveRate;
    // @ApiModelProperty(value = "人脸比对分数")
    private String similarity;
}