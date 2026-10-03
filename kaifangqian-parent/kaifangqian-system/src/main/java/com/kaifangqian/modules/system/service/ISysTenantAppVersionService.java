package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysTenantAppVersion;
import com.kaifangqian.modules.system.vo.SysTenantAppVersionVO;
import com.kaifangqian.modules.system.vo.TenantUserAppReq;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 租户应用服务类
 * @createTime 2022/9/2 18:13
 */
public interface ISysTenantAppVersionService extends IService<SysTenantAppVersion> {

    SysTenantAppVersion getByTenantAndApp(String tenantId, String appId);

    String saveExt(SysTenantAppVersion sysTenantAppVersion);

    List<SysTenantAppVersion> getByTenantId(String tenantId);

    IPage<SysTenantAppVersionVO> pageExt(Page<SysTenantAppVersionVO> page, TenantUserAppReq req);

    void updateStatus(String Id);

    void updateUseful(SysTenantAppVersionVO sysTenantAppVersionVO);
}
