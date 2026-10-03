package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAppVersionGroupPermission;
import com.kaifangqian.modules.system.vo.SysAppVersionGroupPermissionReq;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统版本权限服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAppVersionGroupPermissionService extends IService<SysAppVersionGroupPermission> {

    List<SysAppVersionGroupPermission> listByEntity(SysAppVersionGroupPermission query);

    void editExt(SysAppVersionGroupPermissionReq req);

}
