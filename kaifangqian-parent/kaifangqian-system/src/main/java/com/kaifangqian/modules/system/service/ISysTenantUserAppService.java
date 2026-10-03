package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAppInfo;
import com.kaifangqian.modules.system.entity.SysTenantUserApp;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 租户用户关系管理服务类
 * @createTime 2022/9/2 18:13
 */
public interface ISysTenantUserAppService extends IService<SysTenantUserApp> {

    /**
     * 校验(租户下)用户-应用是否合理:true：合理 false：不合理
     */
    boolean checkUserTenantApp(String userId, String tenantId, String appCode);

    List<SysAppInfo> queryUserApps(String userId, String tenantId);

    String saveExt(SysTenantUserApp sysTenantUserApp);

    void deleteByTenantIdUserIds(String tenantId, List<String> userIds);

    List<String> getByTenantAndAppId(String tenantId, String appId);

    void deleteByTenantAndAppId(String tenantId, String appId);
}
