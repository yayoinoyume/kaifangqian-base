package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.system.entity.SysAuthGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限组表
 * @createTime 2022/9/2 18:12
 */
public interface ISysAuthGroupService extends IService<SysAuthGroup> {

    List<SysAuthGroup> listByEntity(SysAuthGroup sysAuthGroup);

    String saveExt(SysAuthGroup sysAuthGroup);

    void deleteById(String id);

    List<SysAuthGroup> getSystemGroup(String tenantId);

    List<SysAuthGroup> getSystemTypeGroups(Integer type);

    List<SysAuthGroup> getAllSystemTypeGroups(List<Integer> types);
}
