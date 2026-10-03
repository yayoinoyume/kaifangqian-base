/**
 * @description 签署审批服务接口
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuApprove;

import java.util.List;

/**
 * @Description: SignRuApproveService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuApproveService
 * @author: FengLai_Gong
 */
public interface SignRuApproveService extends IService<SignRuApprove> {

    List<SignRuApprove> listByRuId(String ruId);
}