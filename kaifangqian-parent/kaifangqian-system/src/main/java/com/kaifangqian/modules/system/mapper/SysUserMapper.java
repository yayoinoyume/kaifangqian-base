/**
 * Discription:用户表Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.model.SysUserSearchModel;
import org.apache.ibatis.annotations.Param;
import com.kaifangqian.modules.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaifangqian.modules.system.vo.SysUserDepVo;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 用户表 Mapper 接口
 * @createTime 2022/9/2 18:10
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUserSearchModel> queryDepartAllUsers(Page page, @Param("keyWord") String keyWord, @org.apache.ibatis.annotations.Param("departIds") List<String> departIds, @Param("tenantId") String tenantId);

    /**
     * 通过用户账号查询用户信息
     *
     * @param username
     * @return
     */
    SysUser getUserByName(@Param("username") String username);

    /**
     * 根据用户Ids,查询用户所属部门名称信息
     *
     * @param userIds
     * @return
     */
    List<SysUserDepVo> getDepNamesByUserIds(@Param("userIds") List<String> userIds);

    /**
     * 根据用户名设置部门ID
     *
     * @param username
     * @param orgCode
     */
    void updateUserDepart(@Param("username") String username, @Param("orgCode") String orgCode);

    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    SysUser getUserByEmail(@Param("email") String email);
}
