/**
 * @description 业务线编码规则细则生成接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReRuleDetail;

import java.util.List;

/**
 * @Description: SignReRuleDetailService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReRuleDetailService
 * @author: FengLai_Gong
 */
public interface SignReRuleDetailService extends IService<SignReRuleDetail> {


    void deleteByRuleId(String ruleId);

    List<SignReRuleDetail> listByRuleId(String ruleId);

}