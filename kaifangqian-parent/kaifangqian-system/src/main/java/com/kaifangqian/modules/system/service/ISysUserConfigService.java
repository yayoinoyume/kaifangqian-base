package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysUserConfig;
import com.kaifangqian.modules.system.vo.SysUserConfigVO;

/**
 * @author zhenghuihan
 * @description 用户系统配置表
 * @createTime 2022/9/2 17:32
 */
public interface ISysUserConfigService extends IService<SysUserConfig> {

    SysUserConfig getConfigByType(String userId, String type);

    void updatePasswordExt(SysUserConfigVO configVO);

    void updateTypeExt(SysUserConfig userConfig);
}
