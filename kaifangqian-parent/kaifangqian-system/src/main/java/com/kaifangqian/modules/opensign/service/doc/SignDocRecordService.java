/**
 * @description 签署文档数据记录接口类
 */
package com.kaifangqian.modules.opensign.service.doc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignDocRecord;

/**
 * @Description: SignDocRecordService
 * @Package: com.kaifangqian.modules.opensign.service.doc
 * @ClassName: SignDocRecordService
 * @author: FengLai_Gong
 */
public interface SignDocRecordService extends IService<SignDocRecord> {

    SignDocRecord getCurrent(String docId);


    Boolean setNotCurrent(String docId);
}