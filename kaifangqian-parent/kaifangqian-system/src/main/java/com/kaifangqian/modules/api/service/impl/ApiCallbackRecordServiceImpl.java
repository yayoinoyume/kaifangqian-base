/**
 * @description API回调记录服务类
 */
package com.kaifangqian.modules.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.api.entity.ApiCallbackRecord;
import com.kaifangqian.modules.api.mapper.ApiCallbackRecordMapper;
import com.kaifangqian.modules.api.service.IApiCallbackRecordService;
import org.springframework.stereotype.Service;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
@Service
public class ApiCallbackRecordServiceImpl extends ServiceImpl<ApiCallbackRecordMapper, ApiCallbackRecord> implements IApiCallbackRecordService {

}
