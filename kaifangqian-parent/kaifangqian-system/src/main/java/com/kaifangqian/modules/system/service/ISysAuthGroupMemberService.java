package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysAuthGroupMember;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberList;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberList2;
import com.kaifangqian.modules.system.vo.SysAuthGroupMemberVO;
import com.kaifangqian.modules.system.vo.UserAuthGroupVO;
import com.kaifangqian.common.constant.enums.AuthType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 权限组-成员表
 * @createTime 2022/9/2 18:11
 */
public interface ISysAuthGroupMemberService extends IService<SysAuthGroupMember> {

    void saveExt(SysAuthGroupMemberList memberList);

    void saveExt2(SysAuthGroupMemberList2 memberList);

    void removeExt(List<String> ids);

    IPage<SysAuthGroupMemberVO> pageList(Page<SysAuthGroupMemberVO> page, SysAuthGroupMember query);

    IPage<SysAuthGroupMemberVO> listByAuthId(Page<SysAuthGroupMemberVO> page, SysAuthGroupMember query);

    void deleteByTenantIdAndTypeAndAuthIds(String tenantId, AuthType type, List<String> authIds);

    List<UserAuthGroupVO> getLoginUserGroups();
}
