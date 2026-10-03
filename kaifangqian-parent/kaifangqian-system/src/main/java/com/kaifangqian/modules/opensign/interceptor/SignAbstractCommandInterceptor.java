/**
 * @description 签署拦截器抽象类
 */
package com.kaifangqian.modules.opensign.interceptor;

/**
 * @author : zhenghuihan
 * create at:  2022/2/23  3:44 PM
 * @description: 拦截器抽象类
 */
public abstract class SignAbstractCommandInterceptor implements SignCommandInterceptor {

    protected SignCommandInterceptor next;

    @Override
    public SignCommandInterceptor getNext() {
        return next;
    }

    @Override
    public void setNext(SignCommandInterceptor next) {
        this.next = next;
    }
}