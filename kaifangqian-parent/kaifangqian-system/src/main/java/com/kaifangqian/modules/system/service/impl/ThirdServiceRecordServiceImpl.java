package com.kaifangqian.modules.system.service.impl;

import com.kaifangqian.modules.system.entity.ThirdServiceRecord;
import com.kaifangqian.modules.system.mapper.ThirdServiceRecordMapper;
import com.kaifangqian.modules.system.service.IThirdServiceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 第三方接口调用记录表 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2023-10-10
 */
@Service
public class ThirdServiceRecordServiceImpl extends ServiceImpl<ThirdServiceRecordMapper, ThirdServiceRecord> implements IThirdServiceRecordService {

    @Override
    public ThirdServiceRecord saveThirdRecord(String serviceType, String serviceUrl, String reqPara,
                                              boolean successFlag, String resPara, String orderNo) {
        ThirdServiceRecord record = new ThirdServiceRecord();
        record.setServiceType(serviceType);
        record.setServiceUrl(serviceUrl);
        record.setReqPara(reqPara);
        if (MyStringUtils.isNotBlank(resPara) && resPara.length() > 1024) {
            record.setResPara(resPara.substring(0, 1024));
        } else {
            record.setResPara(resPara);
        }
        record.setSuccessFlag(successFlag);
        record.setOrderNo(orderNo);
        save(record);
        return record;
    }
}
