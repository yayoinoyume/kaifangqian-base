/**
 * @description 获取签署文档操作人接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuOperator;

import java.util.List;

/**
 * @Description: SignRuOperatorService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuOperatorService
 * @author: FengLai_Gong
 */
public interface SignRuOperatorService extends IService<SignRuOperator> {

    List<SignRuOperator> listByRuId(String ruId);

    List<SignRuOperator> getByEntity(SignRuOperator query);

    void deleteByRuId(String ruId);
}