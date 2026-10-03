/**
 * @description 签署业务服务接口类，获取签署权限
 */
package com.kaifangqian.modules.opensign.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.service.auth.vo.BusinessAuthQueryVo;
import com.kaifangqian.modules.opensign.entity.SignBusinessAuth;

import java.util.List;

/**
 * @Description: SignBusinessAuthService
 * @Package: com.kaifangqian.modules.opensign.service.auth
 * @ClassName: SignBusinessAuthService
 * @author: FengLai_Gong
 */
public interface SignBusinessAuthService extends IService<SignBusinessAuth> {


    List<SignBusinessAuth> queryAuthList(BusinessAuthQueryVo vo);

    Integer getAuthIdentify(BusinessAuthQueryVo vo);





}