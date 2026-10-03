/**
 * @description 签署文档图片转换数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignDocImageRecord;
import com.kaifangqian.modules.opensign.enums.SignCurrentEnum;
import com.kaifangqian.modules.opensign.mapper.SignDocImageRecordMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocImageRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignDocImageRecordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocImageRecordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocImageRecordServiceImpl extends ServiceImpl<SignDocImageRecordMapper, SignDocImageRecord> implements SignDocImageRecordService {



    @Override
    public List<SignDocImageRecord> getCurrentList(String docId) {
        QueryWrapper<SignDocImageRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignDocImageRecord::getDocId,docId);
        wrapper.lambda().eq(SignDocImageRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public Integer countCurrentList(String docId) {
        QueryWrapper<SignDocImageRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignDocImageRecord::getDocId,docId);
        wrapper.lambda().eq(SignDocImageRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public void updateNotCurrent(String docId) {

        QueryWrapper<SignDocImageRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignDocImageRecord::getDocId,docId);
        wrapper.lambda().eq(SignDocImageRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        SignDocImageRecord record = new SignDocImageRecord();
        record.setIsCurrent(SignCurrentEnum.NOT_CURRENT.getCode());

        this.baseMapper.update(record,wrapper);

    }
}