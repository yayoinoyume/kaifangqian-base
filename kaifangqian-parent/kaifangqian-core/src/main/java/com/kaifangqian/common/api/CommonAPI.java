/**
 * [类功能描述：底层共用API接口]
 */
package com.kaifangqian.common.api;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.system.vo.SysPermissionDataRuleModel;
import com.kaifangqian.common.system.vo.*;

import java.util.List;


/**
 * @Author: zhh
 */
public interface CommonAPI {

    /**
     * 1查询用户权限信息
     */
    List<String> queryUserAuths();

    /**
     * 2-查询用户数据权限
     */
    List<List<List<List<SysPermissionDataRuleModel>>>> queryPermissionDataRule(String perms);

    /**
     * 3-根据部门code查询部门ID
     */
    String getDepartIdByOrgCode(String orgCode);

    /**
     * 4-根据用户账号查询用户信息
     */
    LoginUser getUserByName(String username);

    /**
     * 5-根据用户账号查询角色IDS
     */
    List<String> getMyRoleIds();

    /**
     * 6-根据用户账号查询部门IDS
     */
    List<String> getDepartsByName(String username);

    /**
     * 7-校验用户-租户是否合理:true：合理 false：不合理
     */
    boolean checkUserTenant(String userId, String tenantId);


    /**
     * 8-校验(租户下)用户-部门是否合理:true：合理 false：不合理
     */
    boolean checkUserDepart(String userId, String tenantId, String departId);

    /**
     * 9-校验(租户下)用户-应用是否合理:true：合理 false：不合理
     */
    boolean checkUserTenantApp(String userId, String tenantId, String appCode);

    /**
     * 10-根据租户ID和账号ID获取用户ID
     */
    String getTenantUserId(String tenantId, String userId);

    void recordNormalRes(String res);
}
