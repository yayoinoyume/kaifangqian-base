/**
 * @description 签署业务签章权限管理接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.dto.UserSealAuthListVO;
import com.kaifangqian.modules.opensign.entity.UserSealAuth;

public interface UserSealAuthService extends IService<UserSealAuth> {

    IPage<UserSealAuthListVO> pageExt(Page<UserSealAuthListVO> page, UserSealAuth userSealAuth);

    void saveExt(UserSealAuth userSealAuth);

    void cancle(String id);

    void deleteExt(String id);

    //tenantUserId 租户下用户ID，signReId业务线ID
    UserSealAuth getSealId(String tenantUserId, String signReId);

    void refreshAuth();

}