/**
 * @description 签署业务权限实体类Mapper
 */
package com.kaifangqian.modules.opensign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.opensign.service.auth.vo.BusinessAuthQueryVo;
import com.kaifangqian.modules.opensign.entity.SignBusinessAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: SignBusinessAuthMapper
 * @Package: com.kaifangqian.modules.opensign.mapper
 * @ClassName: SignBusinessAuthMapper
 * @author: FengLai_Gong
 */
public interface SignBusinessAuthMapper extends BaseMapper<SignBusinessAuth> {


    List<SignBusinessAuth> getAuthList(@Param("vo") BusinessAuthQueryVo vo);

    Integer getAuthIdentify(@Param("vo") BusinessAuthQueryVo vo);
}