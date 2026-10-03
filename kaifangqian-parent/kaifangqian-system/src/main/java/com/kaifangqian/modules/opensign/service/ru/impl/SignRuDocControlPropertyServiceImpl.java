/**
 * @description 获取和删除签署文档控件接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuDocControlProperty;
import com.kaifangqian.modules.opensign.enums.ControlPropertyTypeEnum;
import com.kaifangqian.modules.opensign.mapper.SignRuDocControlPropertyMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuDocControlPropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuDocControlPropertyServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignRuDocControlPropertyServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuDocControlPropertyServiceImpl extends ServiceImpl<SignRuDocControlPropertyMapper, SignRuDocControlProperty> implements SignRuDocControlPropertyService {

    @Override
    public void deleteById(String id) {
        this.baseMapper.deleteById(id);
    }

    @Override
    public void deleteByControlId(String controlId) {
        QueryWrapper<SignRuDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocControlProperty::getControlId,controlId);

        this.baseMapper.delete(wrapper);

    }

    @Override
    public void deleteByRuId(String ruId) {
        QueryWrapper<SignRuDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocControlProperty::getRuId,ruId);

        this.baseMapper.delete(wrapper);
    }

    @Override
    public List<SignRuDocControlProperty> listByControlId(String controlId) {
        QueryWrapper<SignRuDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocControlProperty::getControlId,controlId);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuDocControlProperty> listByControlIdList(List<String> controlIdList) {
        QueryWrapper<SignRuDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignRuDocControlProperty::getControlId,controlIdList);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuDocControlProperty> listByDocId(String docId) {
        QueryWrapper<SignRuDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocControlProperty::getPropertyValue,docId);
        wrapper.lambda().eq(SignRuDocControlProperty::getPropertyType, ControlPropertyTypeEnum.RELATION_DOC.getCode());
        return this.baseMapper.selectList(wrapper);
    }

}