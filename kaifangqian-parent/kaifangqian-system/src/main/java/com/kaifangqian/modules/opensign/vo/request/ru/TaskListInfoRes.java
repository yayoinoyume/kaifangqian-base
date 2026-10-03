package com.kaifangqian.modules.opensign.vo.request.ru;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author : zhenghuihan
 * create at:  2023/11/20  14:32
 * @description:
 */
@Data
public class TaskListInfoRes {
    private String taskId;
    private String signRuId;
    private Integer status;
    private String code;
    private String subject;
    //发起方名称
    private String fromTenantName;
    //参与方名称
    private String participateNames;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @ApiModelProperty(value = "创建日期")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @ApiModelProperty(value = "截止时间")
    private Date expireDate;
}