/**
 * @description 个人签署节点实名认证类型配置
 */
package com.kaifangqian.modules.opensign.controller;

import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.opensign.service.business.RuBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.shadow.org.terracotta.offheapstore.HashingMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 个人签署节点实名认证类型配置
 * @Package: com.kaifangqian.modules.opensign.controller
 * @ClassName: PersonalSignAuthController
 * @author: resrun-Y
 */
@Slf4j
@RestController
@RequestMapping("/sign/personal/auth")
@ResrunLogModule(name = "业务线-个人签署节点实名认证类型配置")
public class PersonalSignAuthController {

    @Autowired
    private RuBusinessService ruBusinessService ;

    @RequestMapping(value = "/sys/type", method = RequestMethod.GET)
    public Result<?> getSysPersonalSignAuthType(){

        Map<String, String> result = new HashMap<>();
        String personalSignAuthType = ruBusinessService.getSystemPersonalSignAuthType();
        result.put("personalSignAuthType", personalSignAuthType);

        return Result.OK(result);
    }



}