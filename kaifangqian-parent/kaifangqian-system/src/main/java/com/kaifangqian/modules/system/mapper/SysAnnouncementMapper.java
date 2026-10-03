/**
 * @description 系统通告Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysAnnouncement;

public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {
    IPage<SysAnnouncement> pageExt(Page page, @org.apache.ibatis.annotations.Param("sysAnnouncement") SysAnnouncement sysAnnouncement);
}
