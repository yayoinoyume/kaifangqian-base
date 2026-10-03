package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.system.entity.SysAppVersion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统版本服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAppVersionService extends IService<SysAppVersion> {
    List<SysAppVersion> getByAppIds(List<String> appIds, List<Integer> types, Integer versionStatus);

    void saveExt(SysAppVersion sysAppVersion);

    void updateExt(SysAppVersion sysAppVersion);

    void removeExt(String id);

    void updateStatus(String id);

    void removeBatchExt(List<String> ids);

    List<SysAppVersion> getByIds(List<String> ids);
}
