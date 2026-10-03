/**
 * @description 签署日志拦截器
 */
package com.kaifangqian.modules.opensign.interceptor;

import org.springframework.stereotype.Component;

/**
 * @author : zhenghuihan
 * create at:  2022/2/24  4:45 PM
 * @description: 日志拦截器
 */
@Component
public class SignFlowLogInterceptor extends SignAbstractCommandInterceptor {

    @Override
    public <T> T execute(SignCommandConfig config, SignCommand<T> command) {
        if (config.isLogFlag()) {
            System.out.println("log***************");
        }
        return next.execute(config, command);
    }
}