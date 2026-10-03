/**
 * @description 签署业务服务接口类，获取签章业务权限
 */
package com.kaifangqian.modules.opensign.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignBusinessAuthPermission;

import java.util.List;

/**
 * @Description: SignBusinessAuthPermissionService
 * @Package: com.kaifangqian.modules.opensign.service.auth
 * @ClassName: SignBusinessAuthPermissionService
 * @author: FengLai_Gong
 */
public interface SignBusinessAuthPermissionService extends IService<SignBusinessAuthPermission> {


    List<SignBusinessAuthPermission> getList(Integer businessType ,Integer businessTypeRole);

}