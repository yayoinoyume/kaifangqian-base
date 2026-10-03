/**
 * @description 获取签署文档操作发送人接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuSender;

import java.util.List;

/**
 * @Description: SignRuSenderService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuSenderService
 * @author: FengLai_Gong
 */
public interface SignRuSenderService extends IService<SignRuSender> {

    List<SignRuSender> listBySignerId(String signerId);

    List<SignRuSender> getByEntity(SignRuSender query);
}