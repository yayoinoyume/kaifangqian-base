/**
 * @description 模板图片转换数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignTemplateImageConvert;
import com.kaifangqian.modules.opensign.mapper.SignTemplateImageConvertMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateImageConvertService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignTemplateImageConvertServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateImageConvertServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateImageConvertServiceImpl extends ServiceImpl<SignTemplateImageConvertMapper, SignTemplateImageConvert> implements SignTemplateImageConvertService {



    @Override
    public Integer count(String templateId, String annexId) {
        QueryWrapper<SignTemplateImageConvert> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateImageConvert::getAnnexId,annexId);
        wrapper.lambda().eq(SignTemplateImageConvert::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateImageConvert::getDeleteFlag,false);

        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public List<SignTemplateImageConvert> getList(String templateId, String annexId) {

        QueryWrapper<SignTemplateImageConvert> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateImageConvert::getAnnexId,annexId);
        wrapper.lambda().eq(SignTemplateImageConvert::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateImageConvert::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void delete(String templateId, String annexId) {
        QueryWrapper<SignTemplateImageConvert> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateImageConvert::getAnnexId,annexId);
        wrapper.lambda().eq(SignTemplateImageConvert::getTemplateId,templateId);

        SignTemplateImageConvert signTemplateImageConvert = new SignTemplateImageConvert();
        signTemplateImageConvert.setDeleteFlag(true);
        signTemplateImageConvert.setDeleteTime(new Date());

        this.baseMapper.update(signTemplateImageConvert,wrapper);
    }
}