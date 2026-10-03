/**
 * @description API接口回调地址对象
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
 * @Description: ApiCallbackPageUrl
 * @Package: com.kaifangqian.modules.api.entity
 * @ClassName: ApiCallbackPageUrl
 * @author: FengLai_Gong
 * @Date: 2024/05/09
 */
@Data
@TableName("api_callback_page_url")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ApiCallbackPageUrl implements Serializable {


    private static final long serialVersionUID = 6190473918201954729L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;


    private String callbackPageUrl;

    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;

}