/**
 * @description 签署文档管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuDoc;
import com.kaifangqian.modules.opensign.mapper.SignRuDocMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuDocService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuDocServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuDocServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuDocServiceImpl extends ServiceImpl<SignRuDocMapper, SignRuDoc> implements SignRuDocService {

    @Override
    public List<SignRuDoc> listByRuId(String ruId) {
        QueryWrapper<SignRuDoc> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDoc::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void deleteByRuId(String ruId) {
        QueryWrapper<SignRuDoc> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDoc::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        SignRuDoc doc = new SignRuDoc();
        doc.setDeleteFlag(true);
        this.baseMapper.update(doc,wrapper);
    }

    @Override
    public void deleteByParam(List<String> idList,String ruId) {
        QueryWrapper<SignRuDoc> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignRuDoc::getId,idList);
        wrapper.lambda().eq(SignRuDoc::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignRuDoc doc = new SignRuDoc();
        doc.setDeleteFlag(true);

        this.baseMapper.update(doc,wrapper);
    }

}