package com.kaifangqian.modules.system.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/12/26  10:37
 * @description: 应用版本VO
 */
@Data
public class SysAppVersionVO {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 版本名称
     */
    // @ApiModelProperty(value = "版本名称")
    private String versionName;
    /**
     * 版本描述
     */
    // @ApiModelProperty(value = "版本描述")
    private String versionDesc;

}