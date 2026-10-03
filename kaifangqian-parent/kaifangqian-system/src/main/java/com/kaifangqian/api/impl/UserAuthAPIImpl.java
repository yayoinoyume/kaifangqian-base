package com.kaifangqian.api.impl;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.modules.system.entity.SysDepart;
import com.kaifangqian.modules.system.entity.SysTenantUser;
import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.modules.system.service.*;
import com.kaifangqian.api.UserAuthAPI;
import com.kaifangqian.common.vo.LoginUserInfo;
import com.kaifangqian.common.vo.SysAppInfo;
import com.kaifangqian.common.vo.TenantUserInfo;
import com.kaifangqian.modules.system.entity.*;
import com.kaifangqian.modules.system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @description 用户权限数据
 */

/**
 * @author : zhh
 * create at: 2022/9/16
 */
@Slf4j
@Component
@Primary
public class UserAuthAPIImpl implements UserAuthAPI {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysUserDepartService sysUserDepartService;
    @Autowired
    private ISysTenantUserService sysTenantUserService;
    @Autowired
    private ISysDepartService sysDepartService;
    @Autowired
    private ISysAppInfoService sysAppInfoService;

    @Override
    public List<TenantUserInfo> getUserIdsByDepartIds(List<String> departIds) {
        if (CollUtil.isNotEmpty(departIds)) {
            return sysUserDepartService.getTenantUsersByDeptIds(departIds);
        }
        return null;
    }

    @Override
    public List<TenantUserInfo> getUserIdsByRoleIds(List<String> RoleIds) {
        List<TenantUserInfo> result = sysUserRoleService.getTenantUsersByRoleIds(RoleIds);
        if (CollUtil.isNotEmpty(result)) {
            for (TenantUserInfo t : result) {
                SysDepart query = new SysDepart();
                query.setTenantId(t.getTenantId());
                List<SysDepart> departs = sysDepartService.getByEntity(query);
                if (CollUtil.isNotEmpty(departs)) {
                    t.setDepartId(departs.get(0).getId());
                }
            }
            return result;
        }
        return null;
    }

    @Override
    public List<TenantUserInfo> getUsersByTenantUserIds(List<String> tenantUserIds) {
        List<SysTenantUser> sysTenantUsers = sysTenantUserService.getByIds(tenantUserIds);
        if (CollUtil.isNotEmpty(sysTenantUsers)) {
            List<TenantUserInfo> result = new ArrayList<>();

            for (SysTenantUser t : sysTenantUsers) {
                TenantUserInfo info = new TenantUserInfo();
                info.setTenantUserId(t.getId());
                info.setTenantId(t.getTenantId());
                info.setUserId(t.getUserId());
                SysDepart query = new SysDepart();
                query.setTenantId(t.getTenantId());
                List<SysDepart> departs = sysDepartService.getByEntity(query);
                if (CollUtil.isNotEmpty(departs)) {
                    info.setDepartId(departs.get(0).getId());
                }
                result.add(info);
            }
            return result;
        }
        return new ArrayList<>();
    }

    @Override
    public List<TenantUserInfo> getAllUserIds() {
        List<TenantUserInfo> result = sysTenantUserService.getAllTenantUsers();
        if (CollUtil.isNotEmpty(result)) {
            for (TenantUserInfo t : result) {
                SysDepart query = new SysDepart();
                query.setTenantId(t.getTenantId());
                List<SysDepart> departs = sysDepartService.getByEntity(query);
                if (CollUtil.isNotEmpty(departs)) {
                    t.setDepartId(departs.get(0).getId());
                }
            }
            return result;
        }
        return null;
    }

    @Override
    public List<LoginUserInfo> getUsersByUserIds(List<String> userIds) {
        List<SysUser> sysUsers = sysUserService.findByUserIds(userIds);
        if (CollUtil.isNotEmpty(sysUsers)) {
            List<LoginUserInfo> infos = new ArrayList<>();
            sysUsers.forEach(u -> {
                LoginUserInfo info = new LoginUserInfo();
                info.setId(u.getId());
                info.setEmail(u.getEmail());
                info.setPhone(u.getPhone());
                info.setRealname(u.getRealname());

                infos.add(info);
            });
            return infos;
        }
        return null;
    }

    @Override
    public SysAppInfo getAppInfoByAppId(String appId) {
        SysAppInfo result = new SysAppInfo();
        com.kaifangqian.modules.system.entity.SysAppInfo sysAppInfo = sysAppInfoService.getById(appId);
        if (sysAppInfo != null) {
            result.setId(sysAppInfo.getId());
            result.setAppCode(sysAppInfo.getAppCode());
            result.setAppAddress(sysAppInfo.getAppAddress());
        }
        return result;
    }
}