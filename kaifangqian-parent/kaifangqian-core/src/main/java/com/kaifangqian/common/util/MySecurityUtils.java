/**
 * @description 获取当前登录的用户
 */
package com.kaifangqian.common.util;

import com.kaifangqian.common.system.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

/**
 * @author : zhh
 * create at:  2022/3/16
 */
@Slf4j
public class MySecurityUtils {

    public static final ThreadLocal<LoginUser> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取当前登录的用户
     *
     * @return UserDetails
     */
    public static LoginUser getCurrentUser() {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        if (loginUser != null) {
            return loginUser;
        } else {
            return THREAD_LOCAL.get();
        }
    }
}
