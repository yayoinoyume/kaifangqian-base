package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysPermissionData;
import com.kaifangqian.modules.system.vo.SysPermissionDataVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限策略表
 * @createTime 2022/9/2 18:13
 */
public interface ISysPermissionDataService extends IService<SysPermissionData> {

    IPage<SysPermissionData> pageExt(Page<SysPermissionData> page, String permissionId);


    IPage<SysPermissionData> pageExt2(Page<SysPermissionData> page, String permissionId);

    void addDefault(String permissionId);

    void addCustom(SysPermissionDataVO dataVO);

    void addAllCustom(SysPermissionDataVO dataVO);

    void editCustom(SysPermissionDataVO dataVO);

    void deleteExt(String id);

    SysPermissionDataVO getByIdExt(String id);

    void deleteByPermissionId(String permissionId);

    List<SysPermissionData> listByPermissionId(String permissionId);

    List<SysPermissionData> listTenantRuleByPermissionIds(List<String> permissionIds);
}
