/**
 * @description 业务线签署控件接口服务类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.service.business.vo.ControlQueryVo;
import com.kaifangqian.modules.opensign.entity.SignReDocControl;

import java.util.List;

/**
 * @Description: SignReDocControlService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReDocControlService
 * @author: FengLai_Gong
 */
public interface SignReDocControlService extends IService<SignReDocControl> {


    List<SignReDocControl> listByParam(ControlQueryVo queryVo);

    List<SignReDocControl> listByParam(String reId);

    List<SignReDocControl> listByParam(String reId,String reDocId);

    List<SignReDocControl> listByReIdAndSignerId(String reId,String signerId);

    List<SignReDocControl> listBySignerId(String signerId);

    void deleteByParam(List<String> docIdList ,String reId);

    void deleteSignControlList(String signerId,String reId);

    void deleteById(String controlId);

    void deleteByReId(String reId);

    void resetWriteControlList(String signerId,Integer signerType ,String reId);


}