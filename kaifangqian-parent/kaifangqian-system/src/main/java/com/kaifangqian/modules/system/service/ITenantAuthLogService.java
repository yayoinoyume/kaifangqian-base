package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.TenantAuthLog;
import com.kaifangqian.modules.system.vo.TenantAuthLogVO;
import com.kaifangqian.modules.system.vo.request.TenantAuthAuditRequest;
import com.kaifangqian.modules.system.vo.request.TenantAuthRequest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 租户扩展信息历史记录表 服务类
 * </p>
 *
 * @author Administrator
 * @since 2023-10-10
 */
public interface ITenantAuthLogService extends IService<TenantAuthLog> {


    Page<TenantAuthLogVO> getTenantAuthLog(Page<TenantAuthLog> page, TenantAuthRequest authRequest);

    boolean authAudit(TenantAuthAuditRequest authRequest, String checkUser) throws Exception;


    TenantAuthLogVO getAuthLogById(String logId);

    TenantAuthLog getAuthLogByOrderNo(String tenantId,String orderNo);

    TenantAuthLog getAuthLogByNoAuth(String tenantId);

    TenantAuthLog getAuthLogByNoAuthUpdate(String tenantId);
}
