/**
 * @description 业务线签署文件接口实现类，查询业务线配置文件，删除业务线配置文件
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReDoc;
import com.kaifangqian.modules.opensign.mapper.SignReDocMapper;
import com.kaifangqian.modules.opensign.service.re.SignReDocService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReDocServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReDocServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReDocServiceImpl extends ServiceImpl<SignReDocMapper, SignReDoc> implements SignReDocService {

    @Override
    public List<SignReDoc> listByReId(String reId) {
        QueryWrapper<SignReDoc> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDoc::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void deleteByParam(List<String> idList,String reId) {
        QueryWrapper<SignReDoc> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignReDoc::getId,idList);
        wrapper.lambda().eq(SignReDoc::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReDoc doc = new SignReDoc();
        doc.setDeleteFlag(true);

        this.baseMapper.update(doc,wrapper);
    }


}