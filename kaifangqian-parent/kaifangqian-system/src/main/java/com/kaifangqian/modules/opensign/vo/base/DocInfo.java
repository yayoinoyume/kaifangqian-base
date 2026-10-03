/**
 * @description 文档详情数据对象
 */
package com.kaifangqian.modules.opensign.vo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.modules.storage.entity.AnnexStorage;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: DocInfo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: DocInfo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("文档详情数据对象")
public class DocInfo implements Serializable {

    private static final long serialVersionUID = -4829924328211608565L;

    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("文档主题")
    private String docSubject ;

    // @ApiModelProperty("业务类型字典id")
    private String businessType ;

    // @ApiModelProperty("用印场景类型（1、加盖电子印章；2、加盖物理印章；")
    private Integer sceneType ;

    // @ApiModelProperty("用章类型")
    private Integer sealType ;

    // @ApiModelProperty("用印份数")
    private Integer useCount ;

    // @ApiModelProperty("签章id")
    private String sealId ;

    // @ApiModelProperty("用印事由")
    private String reason ;

    // @ApiModelProperty("发往单位")
    private String sendDept ;

    // @ApiModelProperty("签署截止时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime ;

    // @ApiModelProperty("备注")
    private String note ;

    // @ApiModelProperty("文档状态（待发起、待重新发起、待审批、审批未通过、待签章、签署失败、已完成、已过期、作废）")
    private Integer docStatus ;

    // @ApiModelProperty("发起时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime ;


    // @ApiModelProperty("主文件id")
    private AnnexStorage mainAnnexId ;

    // @ApiModelProperty("其他附件id列表")
    private List<AnnexStorage> otherAnnexList ;
}