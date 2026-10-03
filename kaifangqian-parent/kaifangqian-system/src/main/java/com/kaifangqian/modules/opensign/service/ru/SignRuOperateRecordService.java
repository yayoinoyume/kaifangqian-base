/**
 * @description 获取签署文档操作记录接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuOperateRecord;

import java.util.List;

/**
 * @Description: SignRuOperateRecordService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuOperateRecordService
 * @author: FengLai_Gong
 */
public interface SignRuOperateRecordService extends IService<SignRuOperateRecord> {

    List<SignRuOperateRecord> listByRuId(String ruId);

    List<SignRuOperateRecord> listByOperateList(String ruId,List<String> operateTypeList);

    List<SignRuOperateRecord> listByActionList(String ruId,List<String> actionTypeList);


}