/**
 * @description 签署业务服务接口实现类，获取签署权限
 */
package com.kaifangqian.modules.opensign.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.service.auth.vo.BusinessAuthQueryVo;
import com.kaifangqian.modules.opensign.entity.SignBusinessAuth;
import com.kaifangqian.modules.opensign.mapper.SignBusinessAuthMapper;
import com.kaifangqian.modules.opensign.service.auth.SignBusinessAuthService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignBusinessAuthServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.auth.impl
 * @ClassName: SignBusinessAuthServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignBusinessAuthServiceImpl extends ServiceImpl<SignBusinessAuthMapper, SignBusinessAuth> implements SignBusinessAuthService {

    @Override
    public List<SignBusinessAuth> queryAuthList(BusinessAuthQueryVo vo) {

        return this.baseMapper.getAuthList(vo);
    }

    @Override
    public Integer getAuthIdentify(BusinessAuthQueryVo vo) {
        return this.baseMapper.getAuthIdentify(vo);
    }

}