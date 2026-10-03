/**
 * @Discription:签署API开发者管理服务接口类
 */
package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.ApiDeveloperManage;

public interface IApiDeveloperManageService extends IService<ApiDeveloperManage> {

    ApiDeveloperManage getByToken(String token);

    void saveExt(ApiDeveloperManage apiDeveloperManage);

    void updateExt(ApiDeveloperManage apiDeveloperManage);

    void updateStatus(ApiDeveloperManage apiDeveloperManage);

}
