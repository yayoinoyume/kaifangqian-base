/**
 * @description 签署业务签署临时数据管理接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuSignTemporary;

/**
 * @Description: SignRuSignTemporaryService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuSignTemporaryService
 * @author: FengLai_Gong
 */
public interface SignRuSignTemporaryService extends IService<SignRuSignTemporary> {

    SignRuSignTemporary getByOrderNo(String orderNo);


    SignRuSignTemporary getByParam(String orderNo,String ruId,String taskId);

}