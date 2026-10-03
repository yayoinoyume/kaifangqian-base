/**
 * @description 业务线通知接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignReNotice;
import com.kaifangqian.modules.opensign.mapper.SignReNoticeMapper;
import com.kaifangqian.modules.opensign.service.re.SignReNoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignReNoticeServiceImpl extends ServiceImpl<SignReNoticeMapper, SignReNotice> implements SignReNoticeService {

    @Override
    public Boolean getByReIdAndType(String reId, String type) {
        LambdaQueryWrapper<SignReNotice> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SignReNotice::getSignReId, reId).eq(SignReNotice::getNoticeType, type);

        List<SignReNotice> list = list(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0).getOpenFlag();
        } else {
            SignReNotice signReNotice = new SignReNotice();
            signReNotice.setSignReId(reId);
            signReNotice.setNoticeType(type);
            signReNotice.setOpenFlag(true);

            save(signReNotice);

            return signReNotice.getOpenFlag();
        }
    }

    @Override
    public void updateByReIdAndType(String reId, String type, Boolean flag) {
        LambdaUpdateWrapper<SignReNotice> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SignReNotice::getSignReId, reId).eq(SignReNotice::getNoticeType, type).set(SignReNotice::getOpenFlag, flag);

        update(updateWrapper);
    }
}