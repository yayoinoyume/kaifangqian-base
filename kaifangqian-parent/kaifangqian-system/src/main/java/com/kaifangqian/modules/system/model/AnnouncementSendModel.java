package com.kaifangqian.modules.system.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author zhenghuihan
 * @description 用户通告阅读标记表
 * @createTime 2022/9/2 18:11
 */
@Data
public class AnnouncementSendModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private java.lang.String id;
    /**
     * 通告id
     */
    private java.lang.String anntId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 用户id
     */
    private java.lang.String userId;
    /**
     * 发布人
     */
    private java.lang.String sender;
    /**
     * 标题
     */
    private String title;
    /**
     * 优先级（L低，M中，H高）
     */
    private java.lang.String priority;
    /**
     * 阅读状态
     */
    private Integer isRead;
    /**
     * 发布时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date sendTime;
    /**
     * 阅读时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date readTime;
}
