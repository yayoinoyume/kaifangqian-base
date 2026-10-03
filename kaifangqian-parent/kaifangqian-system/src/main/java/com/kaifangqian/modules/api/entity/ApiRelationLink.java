/**
 * @description 关系链对象
 */
package com.kaifangqian.modules.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:04
 */
@Data
@TableName("api_relation_link")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ApiRelationLink implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 类型
     */
    private String type;
    /**
     * token
     */
    private String token;
    /**
     * 外部标识
     */
    private String externalAccount;
    /**
     * 系统ID
     */
    private String systemId;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
}
