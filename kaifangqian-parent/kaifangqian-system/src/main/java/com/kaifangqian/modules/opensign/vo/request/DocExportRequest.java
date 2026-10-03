package com.kaifangqian.modules.opensign.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: DocExportRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocExportRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档列表导出请求对象")
public class DocExportRequest implements Serializable {

    private static final long serialVersionUID = 5832972372243696697L;

    // @ApiModelProperty("文档主题")
    private String docSubject;
    // @ApiModelProperty("业务类型")
    private String businessType;
    // @ApiModelProperty("用印场景")
    private Integer sceneType ;
    // @ApiModelProperty("发起人")
    private String sender ;
    // @ApiModelProperty("发起部门")
    private String sendDept ;
    // @ApiModelProperty("申请状态")
    private Integer docStatus ;
    // @ApiModelProperty("申请日期-开始时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime ;
    // @ApiModelProperty("申请日期-结束时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime ;



}