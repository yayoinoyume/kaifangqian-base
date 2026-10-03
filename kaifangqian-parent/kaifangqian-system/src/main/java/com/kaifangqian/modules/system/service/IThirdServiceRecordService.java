package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.system.entity.ThirdServiceRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 第三方接口调用记录表 服务类
 * </p>
 *
 * @author Administrator
 * @since 2023-10-10
 */
public interface IThirdServiceRecordService extends IService<ThirdServiceRecord> {

    ThirdServiceRecord saveThirdRecord(String serviceType, String serviceUrl,String reqPara,boolean successFlag,String resPara,String orderNo);
}
