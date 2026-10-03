package com.kaifangqian.api.impl;

import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.common.vo.LoginUserInfo;
import com.kaifangqian.inteface.LoginUserInfoAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/**
 * @description 用户信息实现类
 */

/**
 * @author : zhh
 * create at: 2022/8/16
 */
@Slf4j
@Component
@Primary
public class LoginUserAPIImpl implements LoginUserInfoAPI {
    @Override
    public LoginUserInfo getLoginUserInfo() {
        LoginUser user = MySecurityUtils.getCurrentUser();
        LoginUserInfo userInfo = new LoginUserInfo();
        if (user != null) {
            BeanUtils.copyProperties(user, userInfo);
        }
        return userInfo;
    }
}