/**
 * @description 命令执行器
 */
package com.kaifangqian.modules.opensign.service.flow;

import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandConfig;

/**
 * @author : zhenghuihan
 * create at:  2022/2/17  3:30 PM
 * @description:命令执行器
 */
public interface SignCommandExecutor {

    SignCommandConfig getDefaultConfig();

    <T> T execute(SignCommandConfig config, SignCommand<T> command);

    <T> T execute(SignCommand<T> command);
}