/**
 * @description API警告服务类
 */
package com.kaifangqian.modules.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.api.entity.ApiWarningReq;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
public interface IApiWarningReqService extends IService<ApiWarningReq> {

    void recordWarningReq(ApiWarningReq req);

}
