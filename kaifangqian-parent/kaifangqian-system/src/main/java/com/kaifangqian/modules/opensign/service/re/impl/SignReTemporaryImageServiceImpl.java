/**
 * @description 业务临时文件管理类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReTemporaryImage;
import com.kaifangqian.modules.opensign.mapper.SignReTemporaryImageMapper;
import com.kaifangqian.modules.opensign.service.re.SignReTemporaryImageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReTemporaryImageServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReTemporaryImageServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReTemporaryImageServiceImpl extends ServiceImpl<SignReTemporaryImageMapper, SignReTemporaryImage> implements SignReTemporaryImageService {


    @Override
    public List<SignReTemporaryImage> listByTemporaryId(String temporaryId) {
        QueryWrapper<SignReTemporaryImage> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReTemporaryImage::getTemporaryId,temporaryId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }
}