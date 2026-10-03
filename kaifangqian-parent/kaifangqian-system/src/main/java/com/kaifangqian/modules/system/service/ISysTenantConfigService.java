package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysTenantConfig;

/**
 * @author zhenghuihan
 * @description 租户系统配置服务类
 * @createTime 2022/9/2 18:13
 */
public interface ISysTenantConfigService extends IService<SysTenantConfig> {

    SysTenantConfig getConfigByType(String tenantId, String type);
}
