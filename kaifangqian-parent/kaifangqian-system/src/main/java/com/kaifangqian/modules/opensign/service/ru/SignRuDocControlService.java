/**
 * @description 签署文档控件管理接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.service.business.vo.ControlQueryVo;
import com.kaifangqian.modules.opensign.entity.SignRuDocControl;

import java.util.List;

/**
 * @Description: SignRuDocControlService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuDocControlService
 * @author: FengLai_Gong
 */
public interface SignRuDocControlService extends IService<SignRuDocControl> {


    List<SignRuDocControl> listByParam(ControlQueryVo vo);

    List<SignRuDocControl> listSignControlList(String ruId);

    List<SignRuDocControl> listSignControlBySignerId(String signerId);

    List<SignRuDocControl> listWriteByDocList(List<String> docList);

    Integer countByParam(ControlQueryVo vo);


    void deleteById(String controlId);

    void deleteByParam(List<String> docIdList ,String ruId);

    void deleteSignControlList(String ruId);

    void deleteSignControlList(String signerId,String ruId);

    void resetWriteControlList(String ruId);

    void resetWriteControlList(String signerId,Integer signerType ,String ruId);

}