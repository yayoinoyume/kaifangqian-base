/**
 * @description 业务线签署控件接口服务实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignReDocControlProperty;
import com.kaifangqian.modules.opensign.enums.ControlPropertyTypeEnum;
import com.kaifangqian.modules.opensign.mapper.SignReDocControlPropertyMapper;
import com.kaifangqian.modules.opensign.service.re.SignReDocControlPropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReDocControlPropertyServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReDocControlPropertyServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReDocControlPropertyServiceImpl extends ServiceImpl<SignReDocControlPropertyMapper, SignReDocControlProperty> implements SignReDocControlPropertyService {


    @Override
    public void deleteById(String id) {

        this.baseMapper.deleteById(id);
    }

    @Override
    public void deleteByReId(String reId) {
        QueryWrapper<SignReDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControlProperty::getReId,reId);

        this.baseMapper.delete(wrapper);
    }

    @Override
    public void deleteByControlId(String controlId) {
        QueryWrapper<SignReDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControlProperty::getControlId,controlId);

        this.baseMapper.delete(wrapper);
    }

    @Override
    public List<SignReDocControlProperty> listByControlId(String controlId) {
        QueryWrapper<SignReDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControlProperty::getControlId,controlId);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocControlProperty> listByControlIdList(List<String> controlIdList) {
        QueryWrapper<SignReDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignReDocControlProperty::getControlId,controlIdList);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocControlProperty> listByDocId(String docId) {
        QueryWrapper<SignReDocControlProperty> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControlProperty::getPropertyValue,docId);
        wrapper.lambda().eq(SignReDocControlProperty::getPropertyType, ControlPropertyTypeEnum.RELATION_DOC.getName());
        return this.baseMapper.selectList(wrapper);
    }


}