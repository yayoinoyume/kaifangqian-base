package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.api.vo.request.*;
import com.kaifangqian.modules.api.vo.response.EmployeeRes;
import com.kaifangqian.modules.opensign.vo.base.ConfirmPara;
import com.kaifangqian.modules.system.entity.TenantInfoExtend;
import com.kaifangqian.modules.system.vo.*;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.api.vo.request.*;
import com.kaifangqian.modules.system.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface ITenantInfoExtendService extends IService<TenantInfoExtend> {

    IPage<TenantInfoDTO> pageExt(Page<TenantInfoDTO> page, TenantQueryDTO tenantQueryDTO);

    /**
     * @create by zhenghuihan
     * @createTime 2023/1/30 14:31
     * @description 开通租户
     */
    void saveExt(TenantInfoDTO tenantInfoDTO);

    TenantInfoDTO getByIdExt(String id);

    void editExt(TenantInfoDTO tenantInfoDTO);

    void tenantRegister(UserJionSystemVO userJionSystemVO);

    String personalTenantRegisterForApi(PersonalRegister register);

    void enterpriseTenantRegisterForApi(EnterpriseRegister register);

    void employeeCreate(EmployeeRegister register);

    void employeeModify(EmployeeModify modify);

    void employeeRemove(EmployeeRemove remove);

    EmployeeRes employee(EmployeeQuery info);

    TenantInfoDTO getTenantInfoExt(String tenantId);

    List<TenantInfoDTO> getJoinedEnterprise(String tenantUserId);

    List<TenantInfoExtend> getByEntity(TenantInfoExtend query);

    List<SysTenantInfoExtendVO> listMyTenant();

    ConfirmPara getNameAndNo(String tenantId);

    TenantInfoExtend getTenantInfoByTenantId(String tenantId);

    TenantInfoExtend getTenantInfoByTenantIdAndOrderNo(String tenantId, String orderNo);

    TenantInfoExtend getTenantInfoByOrderNo(String orderNo);

    void updateSysBType(TenantSysBTypeVO vo);

    /**
     * 通过租户名称获取租户信息和企业管理员
     * @param tenantName
     * @return
     */
    TenantCompanyInfoDTO getTenantInfoCompanyInfo(String tenantName) throws Exception;

    /**
     * 创建企业租户
     * @param tenantName
     * @return
     */
    Result<?> createCompanyTenant(TenantCompanyInfoAddVO tenantName);

}
