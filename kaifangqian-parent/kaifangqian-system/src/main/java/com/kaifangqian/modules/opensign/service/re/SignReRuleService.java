/**
 * @description 业务线编码规则生成接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReRule;

import java.util.List;

/**
 * @Description: SignReRuleService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReRuleService
 * @author: FengLai_Gong
 */
public interface SignReRuleService extends IService<SignReRule> {

    List<SignReRule> listByReId(String reId,Integer ruleType);


}