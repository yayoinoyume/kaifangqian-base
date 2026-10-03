package com.kaifangqian.modules.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kaifangqian.modules.system.entity.SysAppVersion;
import com.kaifangqian.modules.system.entity.SysAppVersionPermission;
import com.kaifangqian.modules.system.mapper.SysAppVersionPermissionMapper;
import com.kaifangqian.modules.system.vo.SysAppVersionPermissionVO;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.system.service.ISysAppVersionPermissionService;
import com.kaifangqian.modules.system.service.ISysAppVersionService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author zhenghuihan
 * @description 系统版本权限服务
 * @createTime 2022/9/2 17:40
 */
@Service
public class SysAppVersionPermissionServiceImpl extends ServiceImpl<SysAppVersionPermissionMapper, SysAppVersionPermission> implements ISysAppVersionPermissionService {

    @Autowired
    private ISysAppVersionService iSysAppVersionService;

    @Override
    public List<String> listVersionPermissions(String appVersionId) {
        LambdaQueryWrapper<SysAppVersionPermission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysAppVersionPermission::getAppVersionId, appVersionId);
        List<SysAppVersionPermission> list = this.list(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.stream().map(SysAppVersionPermission::getPermissionId).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public void editVersionPermissions(SysAppVersionPermissionVO vo) {
        if (MyStringUtils.isBlank(vo.getAppVersionId())) {
            throw new PaasException("数据不完整");
        }
        //删除原有数据
        LambdaQueryWrapper<SysAppVersionPermission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysAppVersionPermission::getAppVersionId, vo.getAppVersionId());
        this.remove(queryWrapper);
        //新增数据
        if (CollUtil.isNotEmpty(vo.getPermissions())) {
            SysAppVersion appVersion = iSysAppVersionService.getById(vo.getAppVersionId());
            if (appVersion != null) {
                List<SysAppVersionPermission> permissions = new ArrayList<>();
                vo.getPermissions().forEach(i -> {
                    SysAppVersionPermission permission = new SysAppVersionPermission();
                    permission.setAppInfoId(appVersion.getAppInfoId());
                    permission.setAppVersionId(vo.getAppVersionId());
                    permission.setPermissionId(i);

                    permissions.add(permission);
                });

                this.saveBatch(permissions);
            }
        }
    }
}
