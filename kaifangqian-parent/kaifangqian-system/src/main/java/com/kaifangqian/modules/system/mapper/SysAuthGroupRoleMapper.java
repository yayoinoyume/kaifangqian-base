package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysAuthGroupRole;
import com.kaifangqian.modules.system.vo.SysAuthGroupRoleVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhenghuihan
 * @description 权限组-角色表
 * @createTime 2022/9/2 18:09
 */
public interface SysAuthGroupRoleMapper extends BaseMapper<SysAuthGroupRole> {
    IPage<SysAuthGroupRoleVO> pageExt(Page page, @Param("groupId") String groupId);
}
