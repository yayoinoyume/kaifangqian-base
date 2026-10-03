/**
 * Description:系统通告表
 */
package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.storage.dto.StorageDto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("sys_announcement")
public class SysAnnouncement extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private java.lang.String id;
    /**
     * 标题
     */
    private java.lang.String title;
    /**
     * 类型分类
     */
    private String announcementType;
    /**
     * 开始时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date startTime;
    /**
     * 结束时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date endTime;
    /**
     * 优先级（L低，M中，H高）
     */
    private java.lang.String priority;
    /**
     * 摘要
     */
    private java.lang.String msgAbstract;
    /**
     * 通告对象类型（USER:指定用户，ALL:全体用户）
     */
    private java.lang.String msgType;
    /**
     * 指定用户
     **/
    private java.lang.String userIds;
    /**
     * 内容
     */
    private java.lang.String msgContent;

    /**
     * 发布人
     */
    private java.lang.String sender;
    /**
     * 发布状态（0未发布，1已发布，2已撤销）
     */
    private java.lang.String sendStatus;
    /**
     * 发布时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date sendTime;
    /**
     * 撤销时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date cancelTime;

    private transient String typeName;

    private transient List<StorageDto> files;
}
