package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.system.entity.SysAppVersionPermission;
import com.kaifangqian.modules.system.vo.SysAppVersionPermissionVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统版本权限服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAppVersionPermissionService extends IService<SysAppVersionPermission> {

    List<String> listVersionPermissions(String appVersionId);

    void editVersionPermissions(SysAppVersionPermissionVO vo);
}
