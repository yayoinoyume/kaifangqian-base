/**
 * @description API关系链服务类类
 */
package com.kaifangqian.modules.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.api.entity.ApiRelationLink;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
public interface IApiRelationLinkService extends IService<ApiRelationLink> {

    String getSystemIdByExAccount(String token, String type, String exAccount);

    void removeByExAccount(String token, String type, String exAccount);

    void removeBySystemIds(String type, List<String> systemIds);
}
