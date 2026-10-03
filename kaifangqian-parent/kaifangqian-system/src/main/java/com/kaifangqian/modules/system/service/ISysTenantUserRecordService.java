package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysTenantUserRecord;

/**
 * @author zhenghuihan
 * @description 租户用户申请服务类
 * @createTime 2022/9/2 18:13
 */
public interface ISysTenantUserRecordService extends IService<SysTenantUserRecord> {

    SysTenantUserRecord getByEntity(SysTenantUserRecord query);

    IPage<SysTenantUserRecord> pageExt(Page<SysTenantUserRecord> page, SysTenantUserRecord tenantUserRecord);

    void check(SysTenantUserRecord tenantUserRecord);

}
