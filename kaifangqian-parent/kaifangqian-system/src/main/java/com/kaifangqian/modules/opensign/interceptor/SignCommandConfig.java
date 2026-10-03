/**
 * @description 命令配置类
 */
package com.kaifangqian.modules.opensign.interceptor;

import org.springframework.context.annotation.Configuration;

/**
 * @author : zhenghuihan
 * create at:  2022/2/17  3:33 PM
 * @description: 命令配置类
 */
@Configuration
public class SignCommandConfig {

    private boolean logFlag;

    public SignCommandConfig() {
        this.logFlag = false;
    }

    public SignCommandConfig(boolean logFlag) {
        this.logFlag = logFlag;
    }

    protected SignCommandConfig(SignCommandConfig commandConfig) {
        this.logFlag = commandConfig.logFlag;
    }

    public boolean isLogFlag() {
        return logFlag;
    }


    public SignCommandConfig setContextReusePossible(boolean logFlag) {
        SignCommandConfig config = new SignCommandConfig(this);
        config.logFlag = logFlag;
        return config;
    }

    public SignCommandConfig transactionRequired() {
        SignCommandConfig config = new SignCommandConfig(this);
        return config;
    }

    public SignCommandConfig transactionRequiresNew() {
        SignCommandConfig config = new SignCommandConfig();
        config.logFlag = false;
        return config;
    }

    public SignCommandConfig transactionNotSupported() {
        SignCommandConfig config = new SignCommandConfig();
        config.logFlag = false;
        return config;
    }
}