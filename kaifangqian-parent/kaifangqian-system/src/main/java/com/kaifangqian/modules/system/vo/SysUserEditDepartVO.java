package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/28  18:00
 * @description:用户部门编辑信息
 */
@Data
public class SysUserEditDepartVO {
    private List<String> ids;
    private String hisDepartId;
    private List<String> newDepartIds;
}