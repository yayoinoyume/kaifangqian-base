package com.kaifangqian.modules.system.model;

import lombok.Data;

/**
 * <p>
 * 部门搜索返回对象
 * <p>
 */
@Data
public class SysDepartSearchModel {

    private String id;

    private String parentId;

    private String departName;

    private String orgCode;
}
