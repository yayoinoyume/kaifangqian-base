package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/10/20  16:36
 * @description:
 */
@Data
public class UserAuthGroupVO {
    private String id;
    private String groupName;
    private String groupDesc;
    private Integer groupType;
    private Boolean myFlag = true;
    private String type;
    private String name;
    private String departName;
}