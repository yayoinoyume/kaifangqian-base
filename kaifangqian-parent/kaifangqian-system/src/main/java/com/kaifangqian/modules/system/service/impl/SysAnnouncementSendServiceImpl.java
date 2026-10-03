/**
 * @Discription:公告发送服务接口实现类
 */
package com.kaifangqian.modules.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.SysAnnouncement;
import com.kaifangqian.modules.system.entity.SysAnnouncementSend;
import com.kaifangqian.modules.system.mapper.SysAnnouncementSendMapper;
import com.kaifangqian.modules.system.model.AnnouncementSendModel;
import com.kaifangqian.modules.system.vo.AnnouncementSendReq;
import com.kaifangqian.common.constant.CommonConstant;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.modules.system.service.ISysAnnouncementSendService;
import com.kaifangqian.modules.system.service.ISysAnnouncementService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysAnnouncementSendServiceImpl extends ServiceImpl<SysAnnouncementSendMapper, SysAnnouncementSend> implements ISysAnnouncementSendService {

    @Resource
    private SysAnnouncementSendMapper sysAnnouncementSendMapper;
    @Autowired
    private ISysAnnouncementService iSysAnnouncementService;

    @Override
    public void deleteByAnntId(String anntId) {
        if (MyStringUtils.isNotBlank(anntId)) {
            LambdaQueryWrapper<SysAnnouncementSend> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(SysAnnouncementSend::getAnntId, anntId);

            this.remove(wrapper);
        }
    }

    @Override
    public void saveExt(SysAnnouncementSend sysAnnouncementSend) {
        sysAnnouncementSend.setIsRead(false);
        this.save(sysAnnouncementSend);
    }

    @Override
    public IPage<AnnouncementSendModel> getMyAnnouncementSendPage(Page<AnnouncementSendModel> page,
                                                                  AnnouncementSendReq sendReq) {
        return sysAnnouncementSendMapper.getMyAnnouncementSendList(page, sendReq);
    }

    @Override
    public void computeAndSupplementAnnouncement() {
        LoginUser user = MySecurityUtils.getCurrentUser();
        String userId = user.getId();
        // 1.将系统消息补充到用户通告阅读标记表中
        LambdaQueryWrapper<SysAnnouncement> querySaWrapper = new LambdaQueryWrapper<SysAnnouncement>();
        querySaWrapper.eq(SysAnnouncement::getMsgType, CommonConstant.MSG_TYPE_ALL); // 全部人员
        querySaWrapper.eq(SysAnnouncement::getDeleteFlag, false);  // 未删除
        querySaWrapper.eq(SysAnnouncement::getSendStatus, CommonConstant.PUBLISHED_STATUS_2); //已发布
        querySaWrapper.ge(SysAnnouncement::getEndTime, user.getCreateTime()); //新注册用户不看结束通知
        querySaWrapper.notInSql(SysAnnouncement::getId, "select annt_id from sys_announcement_send where user_id='" + userId + "'");
        List<SysAnnouncement> announcements = iSysAnnouncementService.list(querySaWrapper);
        if (CollUtil.isNotEmpty(announcements)) {
            announcements.forEach(a -> {
                SysAnnouncementSend announcementSend = new SysAnnouncementSend();
                announcementSend.setAnntId(a.getId());
                announcementSend.setUserId(userId);
                announcementSend.setIsRead(false);
                this.save(announcementSend);
            });
        }
    }

    @Override
    public List<SysAnnouncementSend> getByAnntId(String anntId) {
        if (MyStringUtils.isNotBlank(anntId)) {
            LambdaQueryWrapper<SysAnnouncementSend> queryWrapper = new LambdaQueryWrapper<SysAnnouncementSend>();
            queryWrapper.eq(SysAnnouncementSend::getAnntId, anntId);

            return this.list(queryWrapper);
        } else {
            return null;
        }
    }
}
