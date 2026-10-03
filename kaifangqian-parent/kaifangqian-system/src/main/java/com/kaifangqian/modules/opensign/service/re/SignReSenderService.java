/**
 * @description 获取业务线发起人接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReSender;

import java.util.List;

/**
 * @Description: SignReSenderService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReSenderService
 * @author: FengLai_Gong
 */
public interface SignReSenderService extends IService<SignReSender> {

    List<SignReSender> listBySignerId(String signerId);
}