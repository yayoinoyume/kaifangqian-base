/**
 * @description 签署文档图片转换数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignDocImageConvert;
import com.kaifangqian.modules.opensign.mapper.SignDocImageConvertMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocImageConvertService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignDocImageConvertServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocImageConvertServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocImageConvertServiceImpl extends ServiceImpl<SignDocImageConvertMapper, SignDocImageConvert> implements SignDocImageConvertService {


    @Override
    public Integer count(String docId, String annexId) {
        QueryWrapper<SignDocImageConvert> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignDocImageConvert::getAnnexId,annexId);
        wrapper.lambda().eq(SignDocImageConvert::getDocId,docId);
        wrapper.lambda().eq(SignDocImageConvert::getDeleteFlag,false);

        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public List<SignDocImageConvert> getList(String docId, String annexId) {

        QueryWrapper<SignDocImageConvert> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignDocImageConvert::getAnnexId,annexId);
        wrapper.lambda().eq(SignDocImageConvert::getDocId,docId);
        wrapper.lambda().eq(SignDocImageConvert::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void delete(String docId, String annexId) {
        QueryWrapper<SignDocImageConvert> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignDocImageConvert::getAnnexId,annexId);
        wrapper.lambda().eq(SignDocImageConvert::getDocId,docId);

        SignDocImageConvert signDocImageConvert = new SignDocImageConvert();
        signDocImageConvert.setDeleteFlag(true);
        signDocImageConvert.setDeleteTime(new Date());

        this.baseMapper.update(signDocImageConvert,wrapper);
    }
}