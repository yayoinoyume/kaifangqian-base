package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.system.entity.SysTenantInfo;
import com.kaifangqian.modules.system.entity.SysTenantUser;
import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.modules.system.vo.JionRefuseTenantVO;
import com.kaifangqian.common.vo.TenantUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 租户用户关系服务类
 * @createTime 2022/9/2 18:13
 */
public interface ISysTenantUserService extends IService<SysTenantUser> {

    //校验用户-租户是否合理:true：合理 false：不合理
    boolean checkUserTenant(String userId, String tenantId);

    List<SysTenantInfo> getTenantsByUserId(String userId);

    List<SysTenantInfo> getTenantsByUserIdAndAppId(String userId, String appId);

    SysTenantUser getTenantUser(String tenantId, String userId);


    SysTenantUser getActiviTenantUser(String tenantId, String userId);

    List<SysTenantUser> getByIds(List<String> ids);

    List<SysTenantUser> getTenantUsers(String name);

    List<JionRefuseTenantVO> getInviteList();

    void jionOrRefuseTenant(JionRefuseTenantVO vo);

    boolean checkPersonalTenant(String userId);

    List<TenantUserInfo> getAllTenantUsers();

    SysUser getTenantSysUser(String tenantUserId);

    SysTenantUser getPersonalTenantUser(String userId);

    List<SysTenantUser> getTenantSystemUsers();

    List<SysTenantUser> getTenantSystemUsersByTenantId(String companyTenantId);
}
