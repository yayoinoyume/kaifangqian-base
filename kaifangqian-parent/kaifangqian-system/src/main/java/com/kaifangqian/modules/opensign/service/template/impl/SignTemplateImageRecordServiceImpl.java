/**
 * @description 模板图片转换数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignTemplateImageRecord;
import com.kaifangqian.modules.opensign.enums.SignCurrentEnum;
import com.kaifangqian.modules.opensign.mapper.SignTemplateImageRecordMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateImageRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignTemplateImageRecordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateImageRecordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateImageRecordServiceImpl extends ServiceImpl<SignTemplateImageRecordMapper, SignTemplateImageRecord> implements SignTemplateImageRecordService {



    @Override
    public List<SignTemplateImageRecord> getCurrentList(String templateId) {
        QueryWrapper<SignTemplateImageRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignTemplateImageRecord::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateImageRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public Integer countCurrentList(String templateId) {
        QueryWrapper<SignTemplateImageRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignTemplateImageRecord::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateImageRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public void updateNotCurrent(String templateId) {
        QueryWrapper<SignTemplateImageRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignTemplateImageRecord::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateImageRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        SignTemplateImageRecord record = new SignTemplateImageRecord();
        record.setIsCurrent(SignCurrentEnum.NOT_CURRENT.getCode());

        this.baseMapper.update(record,wrapper);
    }
}