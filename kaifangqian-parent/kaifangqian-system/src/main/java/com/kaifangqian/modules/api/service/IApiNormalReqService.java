/**
 * @description API正常回调服务类
 */
package com.kaifangqian.modules.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.api.entity.ApiNormalReq;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
public interface IApiNormalReqService extends IService<ApiNormalReq> {

    void recordNormalReq(ApiNormalReq req);

    void recordNormalRes(String res);
}
