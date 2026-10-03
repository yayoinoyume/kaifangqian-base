/**
 * @description 签署文档操作错误数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignDocRecord;
import com.kaifangqian.modules.opensign.enums.SignCurrentEnum;
import com.kaifangqian.modules.opensign.mapper.SignDocRecordMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocRecordService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignDocRecordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocRecordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocRecordServiceImpl extends ServiceImpl<SignDocRecordMapper, SignDocRecord> implements SignDocRecordService {

    @Override
    public SignDocRecord getCurrent(String docId) {
        QueryWrapper<SignDocRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignDocRecord::getDocId,docId);
        wrapper.lambda().eq(SignDocRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        List<SignDocRecord> signDocRecords = this.baseMapper.selectList(wrapper);
        if(signDocRecords == null || signDocRecords.size() == 0){
            return null;
        }
        return signDocRecords.get(0);
    }

    @Override
    public Boolean setNotCurrent(String docId) {
        QueryWrapper<SignDocRecord> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignDocRecord::getDocId,docId);
        wrapper.lambda().eq(SignDocRecord::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        SignDocRecord record = new SignDocRecord();
        record.setIsCurrent(SignCurrentEnum.NOT_CURRENT.getCode());
        record.setUpdateTime(new Date());

        this.baseMapper.update(record,wrapper);

        return true;
    }

}