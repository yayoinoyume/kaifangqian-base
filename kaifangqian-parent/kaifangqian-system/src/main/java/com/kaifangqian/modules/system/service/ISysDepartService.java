package com.kaifangqian.modules.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysDepart;
import com.kaifangqian.modules.system.model.SysDepartSearchModel;
import com.kaifangqian.modules.system.vo.DepartStasticsVO;
import com.kaifangqian.modules.system.vo.InviteUserVO;
import com.kaifangqian.modules.system.vo.NameAndIdForView;
import com.kaifangqian.modules.system.vo.SysDepartVO;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * <p>
 */
public interface ISysDepartService extends IService<SysDepart> {

    /**
     * 新增组织（顶级）（当前租户下）
     *
     * @param sysDepartVO
     */
    String saveOrganization(SysDepartVO sysDepartVO, String tenantId, String userId);

    /**
     * 新增部门数据（当前租户下）
     *
     * @param sysDepartVO
     */
    void save(SysDepartVO sysDepartVO);

    /**
     * 更新组织、部门数据（当前租户下）
     *
     * @param sysDepartVO
     */
    void update(SysDepartVO sysDepartVO);

    SysDepartVO getByIdExt(String id);

    List<NameAndIdForView> getManagersByIdExt(String id);

    void deleteBatchExt(List<String> ids);


    /**
     * 分层查询我的部门信息
     *
     * @return
     */
    List<SysDepartVO> queryMyList(String departId);

    /**
     * 分层查询所有部门信息
     *
     * @return
     */
    List<SysDepartVO> queryList(String departId);

    /**
     * 查询我的部门信息,并分节点进行显示
     *
     * @return
     */
    List<Tree<String>> queryMyDeptTreeList(List<String> departIds);

    /**
     * 查询我的部门信息,并分节点进行显示
     *
     * @return
     */
    List<Tree<String>> queryMyDeptTreeConcise(List<String> departIds);

    /**
     * 所有部门（我的部门可以操作）（反显使用，不包含用户量）
     *
     * @return
     */
    List<Tree<String>> allDeptTreeConciseForSelect(List<String> departIds);

    /**
     * 查询所有部门信息,并分节点进行显示
     *
     * @return
     */
    List<Tree<String>> queryTreeList();

    /**
     * 根据关键字搜索相关的部门数据
     *
     * @param keyWord
     * @return
     */
    IPage<SysDepartSearchModel> searchMyBy(String keyWord, List<String> departIds, Page<SysDepartSearchModel> page);

    /**
     * 查询租户下用户的SysDepart集合
     *
     * @param userId
     * @param tenantId
     * @return
     */
    List<SysDepart> queryUserDeparts(String userId, String tenantId);

    /**
     * 根据用户名查询部门
     *
     * @param username
     * @return
     */
    List<SysDepart> queryDepartsByUsername(String username);

    /**
     * 根据用户名查询部门Ids
     *
     * @param username
     * @return
     */
    List<String> queryDepartIdsByUsername(String username);


    List<SysDepart> getByOrgCodes(List<String> orgCodes);

    void sendInviteMes(String tenantUserId);

    InviteUserVO inviteUser(String departId);

    List<SysDepart> getByEntity(SysDepart sysDepart);

    //签章使用
    List<SysDepart> getTenantDeparts();

    SysDepart getByOrgCode(String orgCode);

    SysDepart getByTenantId(String tenantId);

    List<SysDepart> queryByDepartIds(List<String> departIds);

    DepartStasticsVO departStastics();

    void batckSendInviteMes();
}
