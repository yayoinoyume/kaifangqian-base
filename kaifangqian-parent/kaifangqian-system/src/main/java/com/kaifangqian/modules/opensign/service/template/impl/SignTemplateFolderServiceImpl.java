/**
 * @description 模板分类数据接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignTemplateFolder;
import com.kaifangqian.modules.opensign.mapper.SignTemplateFolderMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateFolderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignTemplateFolderServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateFolderServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateFolderServiceImpl extends ServiceImpl<SignTemplateFolderMapper, SignTemplateFolder> implements SignTemplateFolderService {



    @Override
    public Integer countChildren(String folderId) {

        QueryWrapper<SignTemplateFolder> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignTemplateFolder::getParentTemplateFolderId,folderId);
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public Integer countChildren(List<String> folderIdList) {
        QueryWrapper<SignTemplateFolder> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().in(SignTemplateFolder::getParentTemplateFolderId,folderIdList);
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public void delete(List<String> folderIdList) {
        QueryWrapper<SignTemplateFolder> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignTemplateFolder::getId,folderIdList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignTemplateFolder folder = new SignTemplateFolder();
        folder.setDeleteFlag(true);
        this.baseMapper.update(folder,wrapper);
    }
}