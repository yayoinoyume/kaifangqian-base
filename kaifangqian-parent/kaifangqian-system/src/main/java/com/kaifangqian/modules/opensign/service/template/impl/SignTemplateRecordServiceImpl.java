/**
 * @description 模板操作记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignTemplateRecord;
import com.kaifangqian.modules.opensign.enums.SignCurrentEnum;
import com.kaifangqian.modules.opensign.mapper.SignTemplateRecordMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateRecordService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignTemplateRecordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateRecordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateRecordServiceImpl extends ServiceImpl<SignTemplateRecordMapper, SignTemplateRecord> implements SignTemplateRecordService {


    @Override
    public SignTemplateRecord getCurrent(String templateId) {
        QueryWrapper<SignTemplateRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignTemplateRecord::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        List<SignTemplateRecord> signTemplateRecords = this.baseMapper.selectList(wrapper);
        if(signTemplateRecords == null || signTemplateRecords.size() == 0){
            return null;
        }
        return signTemplateRecords.get(0);
    }

    @Override
    public Boolean setNotCurrent(String templateId) {

        QueryWrapper<SignTemplateRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignTemplateRecord::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        SignTemplateRecord record = new SignTemplateRecord();
        record.setIsCurrent(SignCurrentEnum.NOT_CURRENT.getCode());
        record.setUpdateTime(new Date());

        this.baseMapper.update(record,wrapper);

        return true;
    }
}