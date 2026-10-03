/**
 * @description 获取业务线签署人接口
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReSigner;

import java.util.List;

/**
 * @Description: SignReSignerService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReSignerService
 * @author: FengLai_Gong
 */
public interface SignReSignerService extends IService<SignReSigner> {


    List<SignReSigner> listByReId(String reId);
}