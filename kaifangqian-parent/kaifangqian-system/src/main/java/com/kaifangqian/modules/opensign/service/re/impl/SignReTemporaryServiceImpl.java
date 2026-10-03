/**
 * @description 业务临时文件管理类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReTemporary;
import com.kaifangqian.modules.opensign.mapper.SignReTemporaryMapper;
import com.kaifangqian.modules.opensign.service.re.SignReTemporaryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReTemporaryServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReTemporaryServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReTemporaryServiceImpl extends ServiceImpl<SignReTemporaryMapper, SignReTemporary> implements SignReTemporaryService {

    @Override
    public List<SignReTemporary> listByReId(String reId) {
        QueryWrapper<SignReTemporary> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReTemporary::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

}