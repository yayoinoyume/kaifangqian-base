/**
 * @description 电子印章-个人印章管理接口类
 */
package com.kaifangqian.modules.opensign.service.seal;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignPersonSeal;

/**
 * @Description: SignPersonSealService
 * @Package: com.kaifangqian.modules.opensign.service.seal
 * @ClassName: SignPersonSealService
 * @author: FengLai_Gong
 */
public interface SignPersonSealService extends IService<SignPersonSeal> {


    Boolean cancelDefault();

    Boolean setDefault(String sealId);

    Boolean delete(String sealId);
}