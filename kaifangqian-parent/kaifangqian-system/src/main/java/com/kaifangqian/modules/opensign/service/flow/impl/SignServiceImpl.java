/**
 * @description 命令执行service继承类
 */
package com.kaifangqian.modules.opensign.service.flow.impl;

import com.kaifangqian.modules.opensign.service.flow.SignCommandExecutor;

/**
 * @author : zhenghuihan
 * create at:  2022/2/17  3:29 PM
 * @description: service继承类
 */
public class SignServiceImpl {
    protected SignCommandExecutor signCommandExecutor;

    public SignCommandExecutor getCommandExecutor() {
        return signCommandExecutor;
    }

    public SignServiceImpl setCommandExecutor(SignCommandExecutor signCommandExecutor) {
        this.signCommandExecutor = signCommandExecutor;
        return this;
    }
}