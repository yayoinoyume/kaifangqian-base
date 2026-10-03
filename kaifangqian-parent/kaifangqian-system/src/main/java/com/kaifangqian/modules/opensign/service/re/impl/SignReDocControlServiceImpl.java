/**
 * @description 业务线签署控件接口服务实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.service.business.vo.ControlQueryVo;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReDocControl;
import com.kaifangqian.modules.opensign.enums.ControlTypeEnum;
import com.kaifangqian.modules.opensign.mapper.SignReDocControlMapper;
import com.kaifangqian.modules.opensign.service.re.SignReDocControlService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReDocControlServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReDocControlServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReDocControlServiceImpl extends ServiceImpl<SignReDocControlMapper, SignReDocControl> implements SignReDocControlService {


    @Override
    public List<SignReDocControl> listByParam(ControlQueryVo queryVo) {

        QueryWrapper wrapper = buildQueryVo(queryVo);
        return this.baseMapper.selectList(wrapper);
    }
    public QueryWrapper buildQueryVo(ControlQueryVo vo){
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        if(vo.getSignerId() != null && vo.getSignerId().length() > 0){
            wrapper.lambda().eq(SignReDocControl::getSignerId,vo.getSignerId());
        }
        if(vo.getSignerIdList() != null && vo.getSignerIdList().size() > 0){
            wrapper.lambda().in(SignReDocControl::getSignerId,vo.getSignerIdList());
        }
        if(vo.getControlType() != null && vo.getControlType().length() > 0){
            wrapper.lambda().eq(SignReDocControl::getControlType,vo.getControlType());
        }
        if(vo.getControlTypeList() != null && vo.getControlTypeList().size() > 0){
            wrapper.lambda().in(SignReDocControl::getControlType,vo.getControlTypeList());
        }
        if(vo.getSignerType() != null){
            wrapper.lambda().eq(SignReDocControl::getSignerType,vo.getSignerType());
        }
        if(vo.getSignReDocId() != null && vo.getSignReDocId().length() > 0){
            wrapper.lambda().eq(SignReDocControl::getSignReDocId,vo.getSignReDocId());
        }
        if(vo.getSignReDocIdList() != null && vo.getSignReDocIdList().size() > 0){
            wrapper.lambda().in(SignReDocControl::getSignReDocId,vo.getSignReDocIdList());
        }
        if(vo.getSignReDocId() != null && vo.getSignReDocId().length() > 0){
            wrapper.lambda().eq(SignReDocControl::getSignReDocId,vo.getSignReDocId());
        }
        if(vo.getErrorStatus() != null){
            wrapper.lambda().eq(SignReDocControl::getErrorStatus,vo.getErrorStatus());
        }
        if(vo.getSignReId() != null && vo.getSignReId().length() > 0){
            wrapper.lambda().eq(SignReDocControl::getSignReId,vo.getSignReId());
        }

        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return wrapper;
    }

    @Override
    public List<SignReDocControl> listByParam(String reId) {
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocControl> listByParam(String reId, String reDocId) {

        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(SignReDocControl::getSignReDocId,reDocId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocControl> listByReIdAndSignerId(String reId, String signerId) {
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(SignReDocControl::getSignerId,signerId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocControl> listBySignerId(String signerId) {
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControl::getSignerId,signerId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void deleteByParam(List<String> docIdList, String reId) {
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignReDocControl::getSignReDocId,docIdList);
        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReDocControl control = new SignReDocControl();
        control.setDeleteFlag(true);

        this.baseMapper.update(control,wrapper);
    }


    @Override
    public void deleteSignControlList(String signerId,String reId) {
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignReDocControl::getControlType, ControlTypeEnum.getSignList());
        wrapper.lambda().eq(SignReDocControl::getSignerId,signerId);

//        wrapper.lambda().eq(SignReDocControl::getSignerType,signerType);

        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReDocControl control = new SignReDocControl();
        control.setDeleteFlag(true);

        this.baseMapper.update(control,wrapper);
    }

    @Override
    public void deleteById(String controlId) {

        SignReDocControl control = new SignReDocControl();
        control.setId(controlId);
        control.setDeleteFlag(true);

        this.baseMapper.updateById(control);
    }

    @Override
    public void deleteByReId(String reId) {
        QueryWrapper<SignReDocControl> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReDocControl control = new SignReDocControl();
        control.setDeleteFlag(true);

        this.baseMapper.update(control,wrapper);
    }

    @Override
    public void resetWriteControlList(String signerId, Integer signerType, String reId) {
        UpdateWrapper<SignReDocControl> wrapper = new UpdateWrapper<>();
        wrapper.lambda().in(SignReDocControl::getControlType, ControlTypeEnum.getWriteList());
        wrapper.lambda().eq(SignReDocControl::getSignerId,signerId);
        wrapper.lambda().eq(SignReDocControl::getSignerType,signerType);

        wrapper.lambda().eq(SignReDocControl::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);


        wrapper.lambda().set(SignReDocControl::getSignerId,null);
        wrapper.lambda().set(SignReDocControl::getSignerType,null );


        this.update(wrapper);
    }


}