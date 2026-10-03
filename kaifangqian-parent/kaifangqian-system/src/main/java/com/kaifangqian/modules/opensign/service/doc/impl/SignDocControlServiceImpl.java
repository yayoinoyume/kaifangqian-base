/**
 * @description 签署文档管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignDocControl;
import com.kaifangqian.modules.opensign.mapper.SignDocControlMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocControlService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignDocControlServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocControlServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocControlServiceImpl extends ServiceImpl<SignDocControlMapper, SignDocControl> implements SignDocControlService {


    @Override
    public Integer count(String docId) {
        QueryWrapper<SignDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignDocControl::getDocId,docId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public List<SignDocControl> getList(String docId) {
        QueryWrapper<SignDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignDocControl::getDocId,docId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void delete(String docId) {
        //删除之前的控件
        QueryWrapper<SignDocControl> updateWrapper = new QueryWrapper<>();
        updateWrapper.lambda().eq(SignDocControl::getDocId,docId);
        updateWrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignDocControl updateEntity = new SignDocControl();
        updateEntity.setDeleteFlag(true);
        updateEntity.setDeleteTime(new Date());
        this.baseMapper.update(updateEntity, updateWrapper);
    }
}