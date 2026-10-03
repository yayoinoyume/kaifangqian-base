/**
 * @description 用户意愿校验订单校验步骤记录接口类
 */
package com.kaifangqian.modules.opensign.service.confirm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignUserConfirmStep;

import java.util.List;

public interface ISignUserConfirmStepService extends IService<SignUserConfirmStep> {

    SignUserConfirmStep getByOrderNo(String orderNo, Integer step);

    List<SignUserConfirmStep> getUnbindData(String confirmType);

    SignUserConfirmStep getByConfirmId(String confirmId);

}