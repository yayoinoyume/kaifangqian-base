package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysDepart;
import com.kaifangqian.modules.system.entity.SysUserDepart;
import com.kaifangqian.modules.system.vo.SysDepartRoleVO;
import com.kaifangqian.modules.system.vo.SysDepartUserVO;
import com.kaifangqian.common.vo.TenantUserInfo;

import java.util.List;

/**
 * <p>
 * SysUserDpeart用户组织机构service
 * </p>
 */
public interface ISysUserDepartService extends IService<SysUserDepart> {

    void addExt(SysUserDepart sysUserDepart);

    void deleteByDepartIdAndUserId(String departId, String userId);

    void deleteByTenantIdAndUserId(String tenantId, String userId);

    void addUserByDepartId(String tennatId, String departId, List<String> userIds);

    void updateManageByDepartId(String departId, List<String> userIds);

    List<SysUserDepart> getByEntity(SysUserDepart query);

    List<SysDepart> getDepartsByUserId(String userId);

    void deleteByTenantIdAndUserIds(String tenantId, List<String> userIds);

    /**
     * 根据部门id查询用户信息(弹框)
     *
     * @param depId
     * @return
     */
    IPage<SysDepartUserVO> queryUserByDepId(String depId, Page<SysDepartUserVO> page);


    /**
     * 根据部门id查询用户信息(列表)
     *
     * @param depId
     * @return
     */
    IPage<SysDepartUserVO> getUserListByDepartId(String depId, Page<SysDepartUserVO> page);


    /**
     * 根据部门id查询人员角色信息
     *
     * @param depId
     * @return
     */
    List<SysDepartRoleVO> getUserRolesByDepartId(String depId);

    List<SysUserDepart> getUserIdsByDeptIds(List<String> deptIds);

    List<TenantUserInfo> getTenantUsersByDeptIds(List<String> deptIds);

    /**
     * 8-校验(租户下)用户-部门是否合理:true：合理 false：不合理
     */
    boolean checkUserDepart(String userId, String tenantId, String departId);
}
