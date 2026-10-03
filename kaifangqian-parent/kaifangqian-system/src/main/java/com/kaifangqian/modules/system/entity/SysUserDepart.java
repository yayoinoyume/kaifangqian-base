package com.kaifangqian.modules.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("sys_user_depart")
public class SysUserDepart implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 部门id
     */
    private String departId;
    /**
     * 是否主管
     */
    private Boolean manageFlag;

    public SysUserDepart() {

    }

    public SysUserDepart(String tenantId, String userId, String departId, Boolean manageFlag) {
        this.tenantId = tenantId;
        this.userId = userId;
        this.departId = departId;
        this.manageFlag = manageFlag;
    }
}
