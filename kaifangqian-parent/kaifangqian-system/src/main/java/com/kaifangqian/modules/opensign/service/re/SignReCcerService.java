/**
 * @description 业务线抄送人接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReCcer;

import java.util.List;

/**
 * @Description: SignReCcerService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReCcerService
 * @author: FengLai_Gong
 */
public interface SignReCcerService extends IService<SignReCcer> {

    List<SignReCcer> listByReId(String reId);


    void deleteByReId(String reId);


}