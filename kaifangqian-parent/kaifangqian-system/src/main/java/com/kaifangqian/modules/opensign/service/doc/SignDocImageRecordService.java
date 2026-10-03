/**
 * @description 签署文档图片转换数据记录接口类
 */
package com.kaifangqian.modules.opensign.service.doc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignDocImageRecord;

import java.util.List;

/**
 * @Description: SignDocImageRecordService
 * @Package: com.kaifangqian.modules.opensign.service.doc
 * @ClassName: SignDocImageRecordService
 * @author: FengLai_Gong
 */
public interface SignDocImageRecordService extends IService<SignDocImageRecord> {


    List<SignDocImageRecord> getCurrentList(String docId);


    Integer countCurrentList(String docId);

    void updateNotCurrent(String docId);
}