/**
 * @description 签署抄送人服务接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuCcer;

import java.util.List;

/**
 * @Description: SignRuCcerService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuCcerService
 * @author: FengLai_Gong
 */
public interface SignRuCcerService extends IService<SignRuCcer> {

    List<SignRuCcer> listByRuId(String ruId);


    List<SignRuCcer> getByEntity(SignRuCcer query);

    void deleteByRuId(String ruId);
}