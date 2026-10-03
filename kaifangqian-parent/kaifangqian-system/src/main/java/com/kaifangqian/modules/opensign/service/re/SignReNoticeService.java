/**
 * @description 业务线通知接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReNotice;

public interface SignReNoticeService extends IService<SignReNotice> {

    Boolean getByReIdAndType(String reId, String type);

    void updateByReIdAndType(String reId, String type, Boolean flag);
}