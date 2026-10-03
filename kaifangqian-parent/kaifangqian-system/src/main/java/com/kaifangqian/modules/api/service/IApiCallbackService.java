/**
 * @description API回调服务类
 */
package com.kaifangqian.modules.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.api.entity.ApiCallback;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
public interface IApiCallbackService extends IService<ApiCallback> {
    boolean addCallback(String url, String data);

    List<ApiCallback> getByStatus(Integer status);


}
