package com.kaifangqian.modules.system.service;

import java.util.List;

import cn.hutool.core.lang.tree.Tree;
import com.kaifangqian.modules.system.entity.SysPermission;
import com.kaifangqian.modules.system.vo.PermisionRuleVO;
import com.kaifangqian.modules.system.vo.UserAuthDataQueryVO;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @Author zhh
 */
public interface ISysPermissionService extends IService<SysPermission> {

    SysPermission getByAppIdAndPerm(String appId, String perm);

    void addPermission(SysPermission sysPermission);

    void editPermission(SysPermission sysPermission);

    void deletePermissionLogical(String id);

    List<SysPermission> listByEntity(SysPermission sysPermission);

    List<SysPermission> listByTypes(String appId, List<Integer> types);

    List<Tree<String>> getTreeList(List<SysPermission> list);

    List<SysPermission> queryByUser(UserAuthDataQueryVO query);

    List<SysPermission> listTenantAppAllMenu(String tenantId, String appId, List<Integer> types);

    List<PermisionRuleVO> listButtonAndAuth(String permissionId);

    List<PermisionRuleVO> listButtonAndAuth2(String versionId, String permissionId);
}
