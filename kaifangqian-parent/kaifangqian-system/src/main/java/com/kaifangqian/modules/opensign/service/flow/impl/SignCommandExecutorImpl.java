/**
 * @description 命令执行器
 */
package com.kaifangqian.modules.opensign.service.flow.impl;

import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandConfig;
import com.kaifangqian.modules.opensign.interceptor.SignCommandInterceptor;
import com.kaifangqian.modules.opensign.service.flow.SignCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : zhenghuihan
 * create at:  2022/2/21  3:29 PM
 * @description:
 */
@Component
public class SignCommandExecutorImpl implements SignCommandExecutor {

    @Autowired
    protected SignCommandConfig defaultConfig;

    protected SignCommandInterceptor first;

    public SignCommandInterceptor getFirst() {
        return first;
    }

    public void setFirst(SignCommandInterceptor commandInterceptor) {
        this.first = commandInterceptor;
    }

    @Override
    public SignCommandConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public <T> T execute(SignCommand<T> command) {
        return execute(defaultConfig, command);
    }

    @Override
    public <T> T execute(SignCommandConfig config, SignCommand<T> command) {
        return first.execute(config, command);
    }
}