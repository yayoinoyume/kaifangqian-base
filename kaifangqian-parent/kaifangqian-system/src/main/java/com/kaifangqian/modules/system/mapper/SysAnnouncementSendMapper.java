/**
 * @description 系统通告发送Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysAnnouncementSend;
import com.kaifangqian.modules.system.model.AnnouncementSendModel;
import com.kaifangqian.modules.system.vo.AnnouncementSendReq;
import org.apache.ibatis.annotations.Param;

public interface SysAnnouncementSendMapper extends BaseMapper<SysAnnouncementSend> {
    IPage<AnnouncementSendModel> getMyAnnouncementSendList(Page<AnnouncementSendModel> page, @Param("sendReq") AnnouncementSendReq sendReq);
}
