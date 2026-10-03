/**
 * @description 获取签署文档清单接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuOperateDocRecord;
import com.kaifangqian.modules.opensign.mapper.SignRuOperateDocRecordMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuOperateDocRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuOperateDocRecordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuOperateDocRecordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuOperateDocRecordServiceImpl extends ServiceImpl<SignRuOperateDocRecordMapper,SignRuOperateDocRecord> implements SignRuOperateDocRecordService {

    @Override
    public List<SignRuOperateDocRecord> listByOperateRecordId(String operateRecordId) {

        QueryWrapper<SignRuOperateDocRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuOperateDocRecord::getOperateRecordId,operateRecordId);
        return this.baseMapper.selectList(wrapper);
    }


}