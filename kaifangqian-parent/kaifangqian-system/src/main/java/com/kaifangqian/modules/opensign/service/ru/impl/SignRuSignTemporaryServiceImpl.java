/**
 * @description 签署业务签署临时数据管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuSignTemporary;
import com.kaifangqian.modules.opensign.mapper.SignRuSignTemporaryMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuSignTemporaryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuSignTemporaryServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuSignTemporaryServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuSignTemporaryServiceImpl extends ServiceImpl<SignRuSignTemporaryMapper, SignRuSignTemporary> implements SignRuSignTemporaryService {

    @Override
    public SignRuSignTemporary getByOrderNo(String orderNo) {
        QueryWrapper<SignRuSignTemporary> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSignTemporary::getSignConfirmOrderNo,orderNo);

        List<SignRuSignTemporary> temporaryList = this.baseMapper.selectList(wrapper);
        if(temporaryList != null && temporaryList.size() > 0){
            return temporaryList.get(0);
        }
        return null;
    }

    @Override
    public SignRuSignTemporary getByParam(String orderNo, String ruId, String taskId) {
        QueryWrapper<SignRuSignTemporary> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSignTemporary::getSignConfirmOrderNo,orderNo);
        wrapper.lambda().eq(SignRuSignTemporary::getSignRuId,ruId);
        wrapper.lambda().eq(SignRuSignTemporary::getTaskId,taskId);
        List<SignRuSignTemporary> temporaryList = this.baseMapper.selectList(wrapper);
        if(temporaryList != null && temporaryList.size() > 0){
            return temporaryList.get(0);
        }
        return null;
    }


}