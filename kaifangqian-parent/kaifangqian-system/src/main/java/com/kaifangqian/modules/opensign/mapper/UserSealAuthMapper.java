/**
 * @description 用户签章授权表Mapper
 */
package com.kaifangqian.modules.opensign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.opensign.dto.UserSealAuthListVO;
import com.kaifangqian.modules.opensign.entity.UserSealAuth;
import org.apache.ibatis.annotations.Param;

public interface UserSealAuthMapper extends BaseMapper<UserSealAuth> {

    IPage<UserSealAuthListVO> pageExt(Page page, @Param("req") UserSealAuth userSealAuth);

}