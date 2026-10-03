/**
 * @Discription:公告发送服务接口类
 */
package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAnnouncementSend;
import com.kaifangqian.modules.system.model.AnnouncementSendModel;
import com.kaifangqian.modules.system.vo.AnnouncementSendReq;

import java.util.List;

public interface ISysAnnouncementSendService extends IService<SysAnnouncementSend> {

    void deleteByAnntId(String anntId);

    void saveExt(SysAnnouncementSend sysAnnouncementSend);

    /**
     * @param sendReq
     * @return
     * @功能：获取我的消息
     */
    IPage<AnnouncementSendModel> getMyAnnouncementSendPage(Page<AnnouncementSendModel> page, AnnouncementSendReq sendReq);

    /**
     * @create by zhenghuihan
     * @createTime 2022/9/26 15:38
     * @description 补充用户公告信息
     */

    void computeAndSupplementAnnouncement();

    List<SysAnnouncementSend> getByAnntId(String anntId);

}
