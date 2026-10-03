/**
 * @description 签署命令继承接口
 */
package com.kaifangqian.modules.opensign.interceptor;

/**
 * @author : zhenghuihan
 * create at:  2022/2/17  3:12 PM
 * @description: 命令继承接口
 */
public interface SignCommand<T> {
    T execute(SignCommandContext signCommandContext) ;
}
