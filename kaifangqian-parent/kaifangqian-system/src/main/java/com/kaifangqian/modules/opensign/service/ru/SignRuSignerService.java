/**
 * @description 签署业务签署人相关接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuSigner;

import java.util.List;

/**
 * @Description: SignRuSignerService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuSignerService
 * @author: FengLai_Gong
 */
public interface SignRuSignerService extends IService<SignRuSigner> {

    List<SignRuSigner> listByRuId(String ruId);

    List<SignRuSigner> getByEntity(SignRuSigner query);

    List<SignRuSigner> getByEntityForApi(SignRuSigner query);

    void deleteByRuId(String ruId);

    void deleteByIdList(List<String> idList);


    List<SignRuSigner> listByRuIds(List<String> ruIds);

}