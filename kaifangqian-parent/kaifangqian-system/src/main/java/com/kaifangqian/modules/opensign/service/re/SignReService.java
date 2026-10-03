/**
 * @description 业务线业务参数校验
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRe;

/**
 * @Description: SignReService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReService
 * @author: FengLai_Gong
 */
public interface SignReService extends IService<SignRe> {

    void checkTemplatePara(SignRe signRe);
}