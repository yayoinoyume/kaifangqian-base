package com.kaifangqian.modules.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.SysAppVersionGroupPermission;
import com.kaifangqian.modules.system.mapper.SysAppVersionGroupPermissionMapper;
import com.kaifangqian.modules.system.vo.PermissionRuleVO;
import com.kaifangqian.modules.system.vo.SysAppVersionGroupPermissionReq;
import com.kaifangqian.modules.system.service.ISysAppVersionGroupPermissionService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统版本权限服务
 * @createTime 2022/9/2 17:40
 */
@Service
public class SysAppVersionGroupPermissionServiceImpl extends ServiceImpl<SysAppVersionGroupPermissionMapper, SysAppVersionGroupPermission> implements ISysAppVersionGroupPermissionService {

    @Override
    public List<SysAppVersionGroupPermission> listByEntity(SysAppVersionGroupPermission query) {
        LambdaQueryWrapper<SysAppVersionGroupPermission> queryWrapper = new LambdaQueryWrapper<SysAppVersionGroupPermission>();
        queryWrapper.eq(MyStringUtils.isNotBlank(query.getGroupId()), SysAppVersionGroupPermission::getGroupId, query.getGroupId())
                .eq(MyStringUtils.isNotBlank(query.getPermissionId()), SysAppVersionGroupPermission::getPermissionId, query.getPermissionId());

        return this.list(queryWrapper);
    }

    @Override
    public void editExt(SysAppVersionGroupPermissionReq req) {
        if (MyStringUtils.isNotBlank(req.getGroupId())) {
            //删除历史数据
            LambdaQueryWrapper<SysAppVersionGroupPermission> deleteQuery = new LambdaQueryWrapper<SysAppVersionGroupPermission>();
            deleteQuery.eq(SysAppVersionGroupPermission::getGroupId, req.getGroupId());
            this.remove(deleteQuery);
            //新增数据
            List<SysAppVersionGroupPermission> newData = new ArrayList<>();
            List<PermissionRuleVO> temDate = req.getRuleVOS();
            if (CollUtil.isNotEmpty(temDate)) {
                temDate.forEach(n -> {
                    if (MyStringUtils.isNotBlank(n.getPermissionId())) {
                        if (CollUtil.isNotEmpty(n.getRuleIds())) {
                            n.getRuleIds().forEach(r -> {
                                SysAppVersionGroupPermission tem = new SysAppVersionGroupPermission();
                                tem.setGroupId(req.getGroupId());
                                tem.setPermissionId(n.getPermissionId());
                                tem.setPermissionDataId(r);

                                newData.add(tem);
                            });
                        } else {
                            SysAppVersionGroupPermission tem = new SysAppVersionGroupPermission();
                            tem.setGroupId(req.getGroupId());
                            tem.setPermissionId(n.getPermissionId());

                            newData.add(tem);
                        }
                    }
                });
            }
            if (CollUtil.isNotEmpty(newData)) {
                this.saveBatch(newData);
            }
        }
    }
}
