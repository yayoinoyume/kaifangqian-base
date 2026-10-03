/**
 * @description 业务线通知控制表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sign_re_notice")
// @ApiModel("业务线通知控制表")
public class SignReNotice extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2546725642070245357L;

    // @ApiModelProperty("'主键'")
    private String id;

    // @ApiModelProperty("业务线主表id")
    private String signReId;


    // @ApiModelProperty("通知类型，1文件填写，2文件签署（发起方内部），3文件签署（外部接收方），4文件抄送（发起方内部 5文件抄送（外部）")
    private String noticeType;

    // @ApiModelProperty("'是否发送'")
    private Boolean openFlag;
}