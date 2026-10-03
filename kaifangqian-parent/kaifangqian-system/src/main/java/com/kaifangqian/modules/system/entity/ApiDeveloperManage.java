package com.kaifangqian.modules.system.entity;

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
 * @description 开发者管理表
 * @createTime 2022/9/2 18:04
 */
@Data
@TableName("api_developer_manage")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ApiDeveloperManage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 名称
     */
    private String developerName;
    /**
     * 授权码
     */
    private String token;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;


    /**
     * 租户id
     **/
    private String tenantId;

    private String callbackUrl;

    private transient String tenantName;
}
