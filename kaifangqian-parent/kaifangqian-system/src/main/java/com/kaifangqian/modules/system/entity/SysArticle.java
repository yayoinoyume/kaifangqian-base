/**
 * Discription:产品发布表
 */
package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String title;
    private String typeId;
    private String author;
    private String summary;
    private String content;
    //状态：0草稿 1已发布 2已下架
    private Integer status;
    private Date publishTime;
    //0 否 1是
    private Boolean upFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private transient String typeName;

    //状态：1:正序 2：倒序
    private transient Integer order = 2;
}
