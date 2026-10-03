/**
 * @description 电子印章-企业印章操作日志接口类
 */
package com.kaifangqian.modules.opensign.service.seal;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignEntSealLogOperate;
import com.kaifangqian.modules.opensign.enums.EntSealOperateTypeEnum;

/**
 * @Description: SignEntSealLogOperateService
 * @Package: com.kaifangqian.modules.opensign.service.seal
 * @ClassName: SignEntSealLogOperateService
 * @author: FengLai_Gong
 */
public interface SignEntSealLogOperateService extends IService<SignEntSealLogOperate> {

    void insert(String sealId , EntSealOperateTypeEnum entSealOperateTypeEnum);
}