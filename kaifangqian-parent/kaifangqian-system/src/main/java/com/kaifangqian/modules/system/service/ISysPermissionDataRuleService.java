package com.kaifangqian.modules.system.service;

import java.util.List;

import com.kaifangqian.modules.system.entity.SysPermissionDataRule;
import com.kaifangqian.modules.system.vo.SysPermissionDataVO;
import com.kaifangqian.modules.system.vo.UserPermissionDataRule;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单权限规则 服务类
 * </p>
 */
public interface ISysPermissionDataRuleService extends IService<SysPermissionDataRule> {

    void updateExt(SysPermissionDataVO dataVO);

    List<SysPermissionDataRule> getByEntity(SysPermissionDataRule query);

    void deleteByDataId(String dataId);

    void deleteByDataIds(List<String> dataIds);

    List<UserPermissionDataRule> queryUserPermissionDataRules(String perms);
}
