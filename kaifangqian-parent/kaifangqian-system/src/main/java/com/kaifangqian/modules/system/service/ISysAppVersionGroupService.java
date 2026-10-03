package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAppVersionGroup;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统版本分组服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAppVersionGroupService extends IService<SysAppVersionGroup> {

    List<SysAppVersionGroup> listByEntity(SysAppVersionGroup query);

    void saveExt(SysAppVersionGroup entity);

    void updateExt(SysAppVersionGroup entity);

    SysAppVersionGroup getByIdExt(String id);

    void updateStatus(String id);
}
