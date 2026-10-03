package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.model.SysDepartSearchModel;
import com.kaifangqian.modules.system.vo.SysDepartVO;
import com.kaifangqian.modules.system.entity.SysDepart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 部门 Mapper 接口
 * <p>
 */

public interface SysDepartMapper extends BaseMapper<SysDepart> {

    /**
     * 根据部门Ids查询部门及以下部门
     */
    List<SysDepart> queryDepartAllList(@org.apache.ibatis.annotations.Param("departIds") List<String> departIds);

    /**
     * 根据部门Ids查询部门及以下部门
     */
    IPage<SysDepartSearchModel> queryDepartAllPage(Page page, @org.apache.ibatis.annotations.Param("departIds") List<String> departIds, @Param("keyWord") String keyWord, @Param("tenantId") String tenantId);

    /**
     * 根据部门Ids查询部门人数
     */
    List<SysDepartVO> countDepartUsers(@org.apache.ibatis.annotations.Param("departIds") List<String> departIds, @Param("tenantId") String tenantId);

    /**
     * 根据部门Ids查询部门主管
     */
    List<SysDepartVO> queryManagesListByDepartIds(@org.apache.ibatis.annotations.Param("departIds") List<String> departIds);

    /**
     * 根据用户ID查询部门集合
     */
    List<SysDepart> queryUserDeparts(@Param("userId") String userId, @Param("tenantId") String tenantId);

    /**
     * 根据父ID分成查询部门集合
     */
    List<SysDepartVO> queryList(@Param("departId") String departId, @Param("tenantId") String tenantId);

    /**
     * 查询我的顶级部门集合
     */
    List<SysDepartVO> queryMyList(@org.apache.ibatis.annotations.Param("orgCodes") List<String> orgCodes, @Param("tenantId") String tenantId);

    /**
     * 根据用户名查询部门
     *
     * @param username
     * @return
     */
    List<SysDepart> queryDepartsByUsername(@Param("username") String username, @Param("tenantId") String tenantId);
}
