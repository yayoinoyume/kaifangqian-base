package com.kaifangqian.modules.opensign.vo.response.ru;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: InfoLinkResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: InfoLinkResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
// @ApiModel("业务线实例-短信链接数据详情-返回数据")
public class InfoLinkResponse implements Serializable {

    private static final long serialVersionUID = -8227874145137753158L;
//    @ApiModelProperty("文档主题")
    private String subject ;

//    @ApiModelProperty("文档编号")
    private String docNo;

//    @ApiModelProperty("发送方名称")
    private String senderName ;

//    @ApiModelProperty("签署方名称")
    private String signerName ;

//    @ApiModelProperty("签署方名称")
    private List<SignRuSignerResponse> signers;

//    @ApiModelProperty("签署状态")
    private Integer signStatus ;

//    @ApiModelProperty("任务状态")
    private Integer taskStatus;

//    @ApiModelProperty("办理动作类型：approve,reject")
    private String checkMenuType;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @ApiModelProperty("'签署截止时间'")
    private Date expireDate ;

//    @ApiModelProperty("文件份数")
    private Integer fileSum;

//    @ApiModelProperty("文件名称")
    private List<String> signFileNames;



}