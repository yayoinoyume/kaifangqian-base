package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.system.entity.SysAuthGroupPermission;
import com.kaifangqian.modules.system.vo.SysAuthGroupPermissionReq;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限组-权限表
 * @createTime 2022/9/2 18:12
 */
public interface ISysAuthGroupPermissionService extends IService<SysAuthGroupPermission> {
    List<SysAuthGroupPermission> listByEntity(SysAuthGroupPermission sysAuthGroupPermission);

    void editExt(SysAuthGroupPermissionReq req);

    void addExt(SysAuthGroupPermissionReq req);

    void deleteByPermissionId(String permissionId);
}
