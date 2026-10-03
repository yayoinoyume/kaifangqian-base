/**
 * @description 签署文档图片转换数据记录接口类
 */
package com.kaifangqian.modules.opensign.service.doc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignDocImageConvert;

import java.util.List;

/**
 * @Description: SignDocImageConvertService
 * @Package: com.kaifangqian.modules.opensign.service.doc
 * @ClassName: SignDocImageConvertService
 * @author: FengLai_Gong
 */
public interface SignDocImageConvertService extends IService<SignDocImageConvert> {


    Integer count(String docId ,String annexId);

    List<SignDocImageConvert> getList(String docId ,String annexId);


    void delete(String docId ,String annexId);
}