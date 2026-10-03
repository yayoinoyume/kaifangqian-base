/**
 * @description 电子印章-企业印章管理接口
 */
package com.kaifangqian.modules.opensign.service.seal;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignEntSeal;
import com.kaifangqian.modules.opensign.enums.EntSealApplyStatusEnum;
import com.kaifangqian.modules.opensign.enums.EntSealStatusEnum;

import java.util.List;

/**
 * @Description: SignEntSealService
 * @Package: com.kaifangqian.modules.opensign.service.doc
 * @ClassName: SignEntSealService
 * @author: FengLai_Gong
 */
public interface SignEntSealService extends IService<SignEntSeal> {

    List<SignEntSeal> getList(String tenantId);

    Boolean updateStatus(EntSealStatusEnum entSealStatus, EntSealApplyStatusEnum entSealApplyStatus, String sealId);
}