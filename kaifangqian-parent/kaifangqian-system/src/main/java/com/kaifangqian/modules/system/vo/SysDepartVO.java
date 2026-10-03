package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  18:26
 * @description:部门信息
 */
@Data
public class SysDepartVO {
    private String id;
    /**
     * 父机构ID
     */
    private String parentId;

    private String parentName;
    /**
     * 机构/部门名称
     */
    private String departName;
    /**
     * 描述
     */
    private String description;
    /**
     * 机构编码
     */
    private String orgCode;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 地址
     */
    private String address;
    /**
     * 排序
     */
    private Integer departOrder;

    List<String> userIds;

    private Integer userCount;

    private String manageNames;

    private Integer childCount;
}