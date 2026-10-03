package com.kaifangqian.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kaifangqian.modules.system.entity.SysAuthGroup;
import com.kaifangqian.modules.system.mapper.SysAuthGroupMapper;
import com.kaifangqian.common.constant.StatusConstant;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.modules.system.service.ISysAuthGroupService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限组表
 * @createTime 2022/9/2 18:16
 */
@Service
public class SysAuthGroupServiceImpl extends ServiceImpl<SysAuthGroupMapper, SysAuthGroup> implements ISysAuthGroupService {

    @Override
    public List<SysAuthGroup> listByEntity(SysAuthGroup sysAuthGroup) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        LambdaQueryWrapper<SysAuthGroup> query = new LambdaQueryWrapper<SysAuthGroup>();
        query.eq(SysAuthGroup::getDeleteFlag, StatusConstant.DEL_FLAG_0)
                .eq(MyStringUtils.isNotBlank(sysAuthGroup.getParentId()), SysAuthGroup::getParentId, sysAuthGroup.getParentId())
                .eq(MyStringUtils.isBlank(sysAuthGroup.getParentId()), SysAuthGroup::getParentId, "")
                .eq(SysAuthGroup::getTenantId, loginUser.getTenantId())
                .like(MyStringUtils.isNotBlank(sysAuthGroup.getGroupName()), SysAuthGroup::getGroupName, sysAuthGroup.getGroupName());

        return this.list(query);
    }

    @Override
    public String saveExt(SysAuthGroup sysAuthGroup) {
        if (MyStringUtils.isBlank(sysAuthGroup.getParentId())) {
            sysAuthGroup.setParentId("");
        }
        this.save(sysAuthGroup);

        return sysAuthGroup.getId();
    }

    @Override
    public void deleteById(String id) {
        LoginUser user = MySecurityUtils.getCurrentUser();
        SysAuthGroup sysAuthGroup = new SysAuthGroup();
        sysAuthGroup.setId(id);
        sysAuthGroup.setDeleteFlag(true);
        sysAuthGroup.setDeleteBy(user.getUsername());
        sysAuthGroup.setDeleteTime(new Date());

        this.updateById(sysAuthGroup);
    }

    @Override
    public List<SysAuthGroup> getSystemGroup(String tenantId) {
        LambdaQueryWrapper<SysAuthGroup> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyStringUtils.isNotBlank(tenantId), SysAuthGroup::getTenantId, tenantId)
                .eq(SysAuthGroup::getSystemFlag, true)
                .ne(SysAuthGroup::getParentId, "");

        return this.list(queryWrapper);
    }

    @Override
    public List<SysAuthGroup> getSystemTypeGroups(Integer type) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        LambdaQueryWrapper<SysAuthGroup> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysAuthGroup::getGroupType, type)
                .eq(SysAuthGroup::getSystemFlag, true)
                .eq(SysAuthGroup::getTenantId, loginUser.getTenantId());

        return this.list(queryWrapper);
    }

    @Override
    public List<SysAuthGroup> getAllSystemTypeGroups(List<Integer> types) {
        LambdaQueryWrapper<SysAuthGroup> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(SysAuthGroup::getGroupType, types);

        return this.list(queryWrapper);
    }
}
