/**
 * @description 业务线签署控件接口服务类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReDocControlProperty;

import java.util.List;

/**
 * @Description: SignReDocControlPropertyService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReDocControlPropertyService
 * @author: FengLai_Gong
 */
public interface SignReDocControlPropertyService extends IService<SignReDocControlProperty> {

    void deleteById(String id);

    void deleteByReId(String reId);

    void deleteByControlId(String controlId);

    List<SignReDocControlProperty> listByControlId(String controlId);

    List<SignReDocControlProperty> listByControlIdList(List<String> controlIdList);

    List<SignReDocControlProperty> listByDocId(String docId);


}