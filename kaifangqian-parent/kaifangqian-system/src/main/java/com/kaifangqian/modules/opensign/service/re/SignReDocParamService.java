/**
 * @description 业务线文档参数接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReDocParam;

import java.util.List;

/**
 * @Description: SignReDocParamService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReDocParamService
 * @author: FengLai_Gong
 */
public interface SignReDocParamService extends IService<SignReDocParam> {

    List<SignReDocParam> listByReDocId(String reDocId);

    List<SignReDocParam> listByReId(String reId);

    List<SignReDocParam> listByReSignerId(String signerId);

    void deleteByRe(String reId);

    void deleteByParam(List<String> reDocIdList ,String reId);

}