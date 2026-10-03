/**
 * @description 业务线实例和驱动关联业务
 */
package com.kaifangqian.modules.opensign.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 业务线实例和驱动关联业务
 * @Package: com.kaifangqian.modules.opensign.service.business
 * @ClassName: RuSignFlowService
 * @author: FengLai_Gong
 */
@Service
public class RuSignFlowService {


    @Autowired
    private RuBusinessService ruBusinessService ;


    /**
     * @Description #填写
     * @Param ruId 业务线实例id
     **/
    public void write(String ruId)  {
        ruBusinessService.write(ruId);
    }

    /**
     * @Description #自动签署
     * @Param signerType 1为发起方 2为接收方
     *        id 关联id，signerType为1时是senderId，为2时是signerId
     **/
    public void autoSign(String id , Integer signerType) {
        ruBusinessService.autoSign(id,signerType);
    }
}