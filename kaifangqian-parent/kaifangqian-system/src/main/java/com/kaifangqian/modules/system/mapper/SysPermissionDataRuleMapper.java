/**
 * Discription:权限规则Mapper
 */
package com.kaifangqian.modules.system.mapper;

import java.util.List;

import com.kaifangqian.modules.system.vo.UserAuthDataQueryVO;
import com.kaifangqian.modules.system.vo.UserPermissionDataRule;
import org.apache.ibatis.annotations.Param;
import com.kaifangqian.modules.system.entity.SysPermissionDataRule;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author zhenghuihan
 * @description 权限规则 Mapper 接口
 * @createTime 2022/9/2 18:10
 */
public interface SysPermissionDataRuleMapper extends BaseMapper<SysPermissionDataRule> {
    List<UserPermissionDataRule> queryUserPermissionDataRules(@Param("query") UserAuthDataQueryVO query);
}
