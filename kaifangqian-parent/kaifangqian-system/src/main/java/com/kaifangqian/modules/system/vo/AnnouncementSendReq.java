package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/9/26  16:00
 * @description:
 */
@Data
public class AnnouncementSendReq {
    /**
     * 标题
     */
    private String title;
    /**
     * 类型分类
     */
    private String announcementType;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 发布人
     */
    private String sender;
    /**
     * 已读1 未读0
     */
    private Integer isRead;
}