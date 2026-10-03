/**
 * @description 业务线分类接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReFolderRelation;
import com.kaifangqian.modules.opensign.mapper.SignReFolderRelationMapper;
import com.kaifangqian.modules.opensign.service.re.SignReFolderRelationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: SignReFolderRelationServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReFolderRelationServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReFolderRelationServiceImpl extends ServiceImpl<SignReFolderRelationMapper, SignReFolderRelation> implements SignReFolderRelationService {

    @Override
    public List<String> getReIdList(String reFolderId) {
        List<String> reIdList = null ;
        QueryWrapper<SignReFolderRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignReFolderRelation::getSignReFolderId,reFolderId);

        List<SignReFolderRelation> signReFolderRelations = this.baseMapper.selectList(wrapper);
        if(signReFolderRelations != null && signReFolderRelations.size() > 0){
            reIdList  = signReFolderRelations.stream().map(SignReFolderRelation::getSignReId).collect(Collectors.toList());
        }

        return reIdList;
    }

    @Override
    public List<SignReFolderRelation> getList(String folderId, List<String> reIdList) {
        QueryWrapper<SignReFolderRelation> queryWrapperRelation = new QueryWrapper<>();
        queryWrapperRelation.lambda().eq(SignReFolderRelation::getSignReFolderId,folderId);
        queryWrapperRelation.lambda().in(SignReFolderRelation::getSignReId,reIdList);
        queryWrapperRelation.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(queryWrapperRelation);
    }

    @Override
    public String getFolderId(String reId) {
        QueryWrapper<SignReFolderRelation> queryWrapperRelation = new QueryWrapper<>();
        queryWrapperRelation.lambda().eq(SignReFolderRelation::getSignReId,reId);
        queryWrapperRelation.lambda().eq(BaseEntity::getDeleteFlag,false);

        List<SignReFolderRelation> signReFolderRelations = this.baseMapper.selectList(queryWrapperRelation);
        if(signReFolderRelations != null && signReFolderRelations.size() > 0){
            SignReFolderRelation relation = signReFolderRelations.get(0);
            return relation.getSignReFolderId();
        }
        return null ;
    }

    @Override
    public Integer count(String folderId) {
        QueryWrapper<SignReFolderRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignReFolderRelation::getSignReFolderId,folderId);
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public Integer count(List<String> folderIdList) {
        QueryWrapper<SignReFolderRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().in(SignReFolderRelation::getSignReFolderId,folderIdList);
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public Boolean delete(String folderId, List<String> reIdList) {
//        //更新原本的文件夹与文件的关系
        QueryWrapper<SignReFolderRelation> sourceQueryWrapper = new QueryWrapper<>();
        sourceQueryWrapper.lambda().eq(SignReFolderRelation::getSignReFolderId,folderId);
        sourceQueryWrapper.lambda().in(SignReFolderRelation::getSignReId,reIdList);
        sourceQueryWrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        SignReFolderRelation sourceRelation = new SignReFolderRelation();
        sourceRelation.setDeleteFlag(true);
        this.baseMapper.update(sourceRelation, sourceQueryWrapper);
        return true ;
    }

    @Override
    public Boolean deleteRelation(String reId) {
        QueryWrapper<SignReFolderRelation> sourceQueryWrapper = new QueryWrapper<>();
        sourceQueryWrapper.lambda().eq(SignReFolderRelation::getSignReId,reId);
        sourceQueryWrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReFolderRelation sourceRelation = new SignReFolderRelation();
        sourceRelation.setDeleteFlag(true);
        this.baseMapper.update(sourceRelation, sourceQueryWrapper);
        return true;

    }

    @Override
    public Boolean deleteRelation(List<String> reIdList) {
        QueryWrapper<SignReFolderRelation> sourceQueryWrapper = new QueryWrapper<>();
        sourceQueryWrapper.lambda().in(SignReFolderRelation::getSignReId,reIdList);
        sourceQueryWrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReFolderRelation sourceRelation = new SignReFolderRelation();
        sourceRelation.setDeleteFlag(true);

        this.baseMapper.update(sourceRelation, sourceQueryWrapper);

        return true;
    }
}