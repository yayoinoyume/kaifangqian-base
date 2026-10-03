/**
 * @description API接口无异常请求
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
@TableName("api_normal_req")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ApiNormalReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * token
     */
    private String token;
    /**
     * 操作人
     */
    private String operatorAccount;
    /**
     * 唯一标识
     */
    private String uniqueCode;
    /**
     * 请求地址
     */
    private String reqUrl;
    /**
     * 请求参数
     */
    private String reqPara;
    /**
     * 返回参数
     */
    private String resPara;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
}
