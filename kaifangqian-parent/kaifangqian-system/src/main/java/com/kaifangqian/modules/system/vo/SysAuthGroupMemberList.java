package com.kaifangqian.modules.system.vo;

import com.kaifangqian.modules.system.entity.SysAuthGroupMember;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/7/6  19:45
 * @description:权限组成员列表
 */
@Data
public class SysAuthGroupMemberList {

    private String tenantId;

    // @ApiModelProperty(value = "权限组id")
    private String groupId;

    private List<SysAuthGroupMember> memberList;
}