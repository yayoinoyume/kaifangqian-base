/**
 * @description 模板管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignTemplateControl;
import com.kaifangqian.modules.opensign.mapper.SignTemplateControlMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateControlService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignTemplateControlServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateControlServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateControlServiceImpl extends ServiceImpl<SignTemplateControlMapper, SignTemplateControl> implements SignTemplateControlService {


    @Override
    public Integer count(String templateId) {
        QueryWrapper<SignTemplateControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateControl::getTemplateId, templateId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public Integer count(List<String> templateIdList) {
        QueryWrapper<SignTemplateControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignTemplateControl::getTemplateId, templateIdList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public List<SignTemplateControl> getList(String templateId) {
        QueryWrapper<SignTemplateControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateControl::getTemplateId, templateId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignTemplateControl> getList(List<String> templateIdList) {
        QueryWrapper<SignTemplateControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignTemplateControl::getTemplateId, templateIdList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        return this.baseMapper.selectList(wrapper);
    }


    @Override
    public void delete(String templateId) {
        //删除之前的控件
        QueryWrapper<SignTemplateControl> updateWrapper = new QueryWrapper<>();
        updateWrapper.lambda().eq(SignTemplateControl::getTemplateId, templateId);
        updateWrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        SignTemplateControl updateEntity = new SignTemplateControl();
        updateEntity.setDeleteFlag(true);
        updateEntity.setDeleteTime(new Date());
        this.baseMapper.update(updateEntity, updateWrapper);
    }


}