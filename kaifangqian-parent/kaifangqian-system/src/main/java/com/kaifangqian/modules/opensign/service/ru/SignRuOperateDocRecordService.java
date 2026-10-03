/**
 * @description 获取签署文档清单接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuOperateDocRecord;

import java.util.List;

/**
 * @Description: SignRuOperateDocRecordService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuOperateDocRecordService
 * @author: FengLai_Gong
 */
public interface SignRuOperateDocRecordService extends IService<SignRuOperateDocRecord> {


    List<SignRuOperateDocRecord> listByOperateRecordId(String operateRecordId);


}