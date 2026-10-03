/**
 * @description 业务线权限控制表Mapper
 */
package com.kaifangqian.modules.opensign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.opensign.entity.SignReAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: SignReAuthMapper
 * @Package: com.kaifangqian.modules.opensign.mapper
 * @ClassName: SignReAuthMapper
 * @author: FengLai_Gong
 */
public interface SignReAuthMapper extends BaseMapper<SignReAuth> {

    List<String> getMyViewSignRe(@Param("tenantUserId") String tenantUserId);
}