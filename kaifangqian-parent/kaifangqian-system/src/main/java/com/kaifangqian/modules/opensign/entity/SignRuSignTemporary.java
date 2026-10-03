/**
 * @description 业务线实例-提交签署临时数据
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuSignTemporary
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuSignTemporary
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_sign_temporary")
// @ApiModel("业务线实例-提交签署临时数据")
public class SignRuSignTemporary extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -5051322056200600601L;

    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    // @ApiModelProperty("任务id")
    private String taskId ;

    // @ApiModelProperty("参数")
    private String params ;

    // @ApiModelProperty("状态,0是进行中，1是已完成")
    private Integer status ;


}