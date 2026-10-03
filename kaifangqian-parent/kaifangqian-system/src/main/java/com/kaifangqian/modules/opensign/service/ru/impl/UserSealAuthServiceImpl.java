/**
 * @description 签署业务签章权限管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.UserSealAuth;
import com.kaifangqian.modules.system.entity.TenantInfoExtend;
import com.kaifangqian.modules.system.enums.UpdatePasswordEnum;
import com.kaifangqian.common.redis.util.RedisUtil;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.opensign.dto.UserSealAuthListVO;
import com.kaifangqian.modules.opensign.entity.*;
import com.kaifangqian.modules.opensign.mapper.UserSealAuthMapper;
import com.kaifangqian.modules.opensign.service.ru.UserSealAuthService;
import com.kaifangqian.modules.system.service.ISysUserConfigService;
import com.kaifangqian.modules.system.service.ITenantInfoExtendService;
import com.kaifangqian.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserSealAuthServiceImpl extends ServiceImpl<UserSealAuthMapper, UserSealAuth> implements UserSealAuthService {

    @Resource
    private UserSealAuthMapper mapper;

    @Override
    public IPage<UserSealAuthListVO> pageExt(Page<UserSealAuthListVO> page, UserSealAuth userSealAuth) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        userSealAuth.setTenantUserId(loginUser.getTenantUserId());
        return mapper.pageExt(page, userSealAuth);
    }

    @Autowired
    private ITenantInfoExtendService tenantInfoExtendService;
    @Autowired
    private ISysUserConfigService sysUserConfigService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void saveExt(UserSealAuth userSealAuth) {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        //校验是否实名
        TenantInfoExtend tenantInfoExtend = tenantInfoExtendService.getTenantInfoByTenantId(loginUser.getTenantId());
        if (tenantInfoExtend == null) {
            throw new PaasException("用户错误");
        }
        if (tenantInfoExtend.getAuthStatus() != 2) {
            throw new PaasException("用户未实名");
        }
        //意愿校验
//        if (MyStringUtils.isBlank(userSealAuth.getConfirmType())) {
//            throw new PaasException("意愿校验类型不能为空");
//        }
        if (userSealAuth.getAuthTime() == null) {
            throw new PaasException("授权时间不能为空");
        }
        if (!userSealAuth.getAuthTime().after(DateUtil.beginOfDay(new Date()))) {
            throw new PaasException("授权时间不能小于当前时间");
        }

//        boolean checkFlag = false;
//        String typeValue = "";
//        if (ConfirmTypeEnum.DOUBLE.getType().equals(userSealAuth.getConfirmType())) {
//            if (checkCode(loginUser, userSealAuth)) {
//                if (UpdatePasswordEnum.PHONE.getType().equals(userSealAuth.getType())) {
//                    typeValue = loginUser.getPhone();
//                } else if (UpdatePasswordEnum.EMIAL.getType().equals(userSealAuth.getType())) {
//                    typeValue = loginUser.getEmail();
//                }
//                SysUserConfig userConfig = sysUserConfigService.getConfigByType(loginUser.getId(), CommonConstant.USERSIGNPASSWORDKEY);
//                if (userConfig == null || MyStringUtils.isBlank(userConfig.getValue())) {
//                    throw new PaasException("签署密码未设置");
//                }
//                if (MyStringUtils.isNotBlank(userSealAuth.getPassword()) || userSealAuth.getPassword().equals(userConfig.getValue())) {
//                    checkFlag = true;
//                }
//            }
//        } else if (ConfirmTypeEnum.PHONE_EMAIL.getType().equals(userSealAuth.getConfirmType())) {
//            checkFlag = checkCode(loginUser, userSealAuth);
//            if (UpdatePasswordEnum.PHONE.getType().equals(userSealAuth.getType())) {
//                typeValue = loginUser.getPhone();
//            } else if (UpdatePasswordEnum.EMIAL.getType().equals(userSealAuth.getType())) {
//                typeValue = loginUser.getEmail();
//            }
//        } else if (ConfirmTypeEnum.PAASWORD.getType().equals(userSealAuth.getConfirmType())) {
//            SysUserConfig userConfig = sysUserConfigService.getConfigByType(loginUser.getId(), CommonConstant.USERSIGNPASSWORDKEY);
//            if (userConfig == null || MyStringUtils.isBlank(userConfig.getValue())) {
//                throw new PaasException("签署密码未设置");
//            }
//            if (MyStringUtils.isNotBlank(userSealAuth.getPassword()) && userSealAuth.getPassword().equals(userConfig.getValue())) {
//                checkFlag = true;
//            }
//        } else {
//            throw new PaasException("校验类型不支持");
//        }
//        if (!checkFlag) {
//            throw new PaasException("校验不通过");
//        }
        //入库
        userSealAuth.setTenantUserId(loginUser.getTenantUserId());
        userSealAuth.setAuthStatus(1);
//        userSealAuth.setTypeValue(typeValue);
//        userSealAuth.setUserPara(userSealAuth.getCaptcha());

        this.save(userSealAuth);
    }

    boolean checkCode(LoginUser loginUser, UserSealAuth userSealAuth) {
        String typeValue = "";
        if (UpdatePasswordEnum.PHONE.getType().equals(userSealAuth.getType())) {
            typeValue = loginUser.getPhone();
        } else if (UpdatePasswordEnum.EMIAL.getType().equals(userSealAuth.getType())) {
            typeValue = loginUser.getEmail();
        } else {
            throw new PaasException("类型不支持");
        }
        String realKey = MD5Util.MD5Encode(typeValue + userSealAuth.getCaptchaKey(), "utf-8");
        Object checkCode = redisUtil.get(realKey);
        if (checkCode != null && checkCode.toString().equals(userSealAuth.getCaptcha())) {
            return true;
        }
        return false;
    }


    @Override
    public void cancle(String id) {
        UserSealAuth tem = this.getById(id);
        if (tem != null && tem.getAuthStatus() == 1) {
            tem.setAuthStatus(0);
            updateById(tem);
        }
    }

    @Override
    public void deleteExt(String id) {
        UserSealAuth tem = this.getById(id);
        if (tem != null && tem.getAuthStatus() == 0) {
            LoginUser loginUser = MySecurityUtils.getCurrentUser();
            tem.setDeleteBy(loginUser.getUsername());
            tem.setDeleteFlag(true);
            tem.setDeleteTime(new Date());

            updateById(tem);
        }
    }

    @Override
    public UserSealAuth getSealId(String tenantUserId, String signReId) {
        LambdaQueryWrapper<UserSealAuth> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserSealAuth::getTenantUserId, tenantUserId).eq(UserSealAuth::getSignReId, signReId).eq(UserSealAuth::getAuthStatus, 1).eq(UserSealAuth::getDeleteFlag, false);
        List<UserSealAuth> list = list(queryWrapper);

        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public void refreshAuth() {
        LambdaUpdateWrapper<UserSealAuth> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserSealAuth::getAuthStatus, 1).le(UserSealAuth::getAuthTime, DateUtil.beginOfDay(new Date())).set(UserSealAuth::getAuthStatus, 0);

        // 更新状态
        update(updateWrapper);
    }
}