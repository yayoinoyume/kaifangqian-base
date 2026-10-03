/**
 * @description 签署命令拦截器
 */
package com.kaifangqian.modules.opensign.interceptor;

/**
 * @author : zhenghuihan
 * create at:  2022/2/17  3:32 PM
 * @description: 命令拦截器
 */
public interface SignCommandInterceptor {
    <T> T execute(SignCommandConfig config, SignCommand<T> command);

    SignCommandInterceptor getNext();

    void setNext(SignCommandInterceptor next);
}