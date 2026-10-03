package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberVO;
import com.kaifangqian.modules.system.entity.SysAuthGroupMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.system.vo.UserAuthDataQueryVO;
import com.kaifangqian.modules.system.vo.UserAuthGroupVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限组-成员表
 * @createTime 2022/9/2 18:09
 */
public interface SysAuthGroupMemberMapper extends BaseMapper<SysAuthGroupMember> {
    IPage<SysAuthGroupMemberVO> pageList(Page page, @Param("query") SysAuthGroupMember query);

    IPage<SysAuthGroupMemberVO> listByAuthId(Page page, @Param("query") SysAuthGroupMember query);

    List<UserAuthGroupVO> getLoginUserGroups(@Param("query") UserAuthDataQueryVO query);
}
