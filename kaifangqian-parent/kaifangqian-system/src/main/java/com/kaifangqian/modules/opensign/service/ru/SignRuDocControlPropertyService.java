/**
 * @description 获取和删除签署文档控件接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuDocControlProperty;

import java.util.List;

/**
 * @Description: SignRuDocControlPropertyService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignRuDocControlPropertyService
 * @author: FengLai_Gong
 */
public interface SignRuDocControlPropertyService extends IService<SignRuDocControlProperty> {


    void deleteById(String id);

    void deleteByControlId(String controlId);

    void deleteByRuId(String ruId);

    List<SignRuDocControlProperty> listByControlId(String controlId);

    List<SignRuDocControlProperty> listByControlIdList(List<String> controlIdList);

    List<SignRuDocControlProperty> listByDocId(String docId);

}