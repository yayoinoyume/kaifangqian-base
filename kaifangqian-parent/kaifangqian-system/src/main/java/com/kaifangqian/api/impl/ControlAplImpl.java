package com.kaifangqian.api.impl;

import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.inteface.ControlAPI;
import com.kaifangqian.modules.system.service.ISysUserService;
import com.kaifangqian.utils.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/**
 * @description 控制实现类
 */

/**
 * @author : zhh
 * create at: 2022/7/13
 */
@Slf4j
@Component
@Primary
public class ControlAplImpl implements ControlAPI {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public boolean checkPassword(String password) {
        LoginUser user = MySecurityUtils.getCurrentUser();
        SysUser sysUser = sysUserService.getById(user.getId());
        String userpassword = PasswordUtil.encrypt(sysUser.getUsername(), password, sysUser.getSalt());
        String syspassword = sysUser.getPassword();
        if (syspassword.equals(userpassword)) {
            return true;
        }
        return false;
    }
}