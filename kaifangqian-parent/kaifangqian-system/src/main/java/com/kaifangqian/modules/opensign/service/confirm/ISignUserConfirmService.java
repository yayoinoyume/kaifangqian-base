/**
 * @description 用户意愿校验订单接口类
 */
package com.kaifangqian.modules.opensign.service.confirm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignUserConfirm;
import com.kaifangqian.modules.opensign.vo.request.ConfirmParaRequest;

public interface ISignUserConfirmService extends IService<SignUserConfirm> {

    String saveExt(String taskId);

    void confirmPara(ConfirmParaRequest confirmPara);

    void setFlag(String orderNo, Boolean flag);

    SignUserConfirm getByMainId(String mainId);

}