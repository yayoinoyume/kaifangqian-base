/**
 * @description 签署文档管理接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuDoc;

import java.util.List;

/**
 * @Description: SignRuDocService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuDocService
 * @author: FengLai_Gong
 */
public interface SignRuDocService extends IService<SignRuDoc> {

    List<SignRuDoc> listByRuId(String ruId);

    void deleteByRuId(String ruId);

    void deleteByParam(List<String> idList,String ruId);
}