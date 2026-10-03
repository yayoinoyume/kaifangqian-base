package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAnnouncement;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统公告服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAnnouncementService extends IService<SysAnnouncement> {

    void saveAnnouncement(SysAnnouncement sysAnnouncement);

    void updateAnnouncement(SysAnnouncement sysAnnouncement);

    IPage<SysAnnouncement> pageExt(Page<SysAnnouncement> page, SysAnnouncement sysAnnouncement);

    void deleteBatchByIdsExt(List<String> ids);

    SysAnnouncement getByIdExt(String id);

    void doReleaseData(String id);

    void doReovkeData(String id);

    List<SysAnnouncement> getJobPublishedList();

    List<SysAnnouncement> getJobPublishingList();
}
