/**
 * @description 业务线文件夹管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReFolder;
import com.kaifangqian.modules.opensign.mapper.SignReFolderMapper;
import com.kaifangqian.modules.opensign.service.re.SignReFolderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReFolderServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReFolderServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReFolderServiceImpl extends ServiceImpl<SignReFolderMapper, SignReFolder> implements SignReFolderService {


    @Override
    public Integer countChildren(List<String> folderIdList) {
        QueryWrapper<SignReFolder> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().in(SignReFolder::getParentReFolderId,folderIdList);
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public void delete(List<String> folderIdList) {
        QueryWrapper<SignReFolder> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignReFolder::getId,folderIdList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReFolder folder = new SignReFolder();
        folder.setDeleteFlag(true);
        this.baseMapper.update(folder,wrapper);
    }
    
    
}