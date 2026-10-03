/**
 * @description 签署附件服务接口实现类
 */
package com.kaifangqian.modules.opensign.service.annex.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.service.annex.AnnexImageService;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.AnnexImage;
import com.kaifangqian.modules.opensign.mapper.AnnexImageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: AnnexImageServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: AnnexImageServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class AnnexImageServiceImpl extends ServiceImpl<AnnexImageMapper, AnnexImage> implements AnnexImageService {


    @Override
    public List<AnnexImage> listByAnnexId(String annexId) {
        QueryWrapper<AnnexImage> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AnnexImage::getAnnexId,annexId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public Integer countByAnnexId(String annexId) {
        QueryWrapper<AnnexImage> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AnnexImage::getAnnexId,annexId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectCount(wrapper).intValue();
    }


}