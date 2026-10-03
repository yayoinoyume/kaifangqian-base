/**
 * @description 获取签署文档操作记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuOperateRecord;
import com.kaifangqian.modules.opensign.mapper.SignRuOperateRecordMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuOperateRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuOperateRecordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuOperateRecordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuOperateRecordServiceImpl extends ServiceImpl<SignRuOperateRecordMapper, SignRuOperateRecord> implements SignRuOperateRecordService {


    @Override
    public List<SignRuOperateRecord> listByRuId(String ruId) {

        QueryWrapper<SignRuOperateRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuOperateRecord::getSignRuId,ruId);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuOperateRecord> listByOperateList(String ruId, List<String> operateTypeList) {
        QueryWrapper<SignRuOperateRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuOperateRecord::getSignRuId,ruId);
        wrapper.lambda().in(SignRuOperateRecord::getOperateType,operateTypeList);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuOperateRecord> listByActionList(String ruId, List<String> actionTypeList) {
        QueryWrapper<SignRuOperateRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuOperateRecord::getSignRuId,ruId);
        wrapper.lambda().in(SignRuOperateRecord::getActionType,actionTypeList);
        return this.baseMapper.selectList(wrapper);
    }


}