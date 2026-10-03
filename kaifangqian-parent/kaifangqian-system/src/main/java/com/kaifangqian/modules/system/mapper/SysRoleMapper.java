/**
 * Discription:角色表Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.kaifangqian.modules.system.vo.UserAuthDataQueryVO;
import org.apache.ibatis.annotations.Param;
import com.kaifangqian.modules.system.entity.SysRole;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户查询用户角色
     */
    List<SysRole> getMyRoles(@Param("query") UserAuthDataQueryVO query);
}
