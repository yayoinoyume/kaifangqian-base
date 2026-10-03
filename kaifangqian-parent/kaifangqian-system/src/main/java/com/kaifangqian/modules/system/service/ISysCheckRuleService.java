package com.kaifangqian.modules.system.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysCheckRule;

/**
 * @author zhenghuihan
 * @description 编码校验规则
 * @createTime 2022/9/2 18:12
 */
public interface ISysCheckRuleService extends IService<SysCheckRule> {

    /**
     * 通过 code 获取规则
     *
     * @param ruleCode
     * @return
     */
    SysCheckRule getByCode(String ruleCode);


    /**
     * 通过用户设定的自定义校验规则校验传入的值
     *
     * @param checkRule
     * @param value
     * @return 返回 null代表通过校验，否则就是返回的错误提示文本
     */
    JSONObject checkValue(SysCheckRule checkRule, String value);

}
