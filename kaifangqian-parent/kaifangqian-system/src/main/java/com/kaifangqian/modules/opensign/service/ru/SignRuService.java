/**
 * @description 签署文档主业务接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.entity.SignRuTask;

import java.util.Date;
import java.util.List;

/**
 * @Description: SignRuServoice
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuServoice
 * @author: FengLai_Gong
 */
public interface SignRuService extends IService<SignRu> {

    Integer countMyByStatus(Integer status, List<Integer> statusList);

    void updateStatus();


    Boolean updateExpireDate(Date expireDate, String id);

    Boolean checkDownloadAuth(String signRuId);

    Boolean checkViewAuth(String signRuId);

    /**
     * @create by zhenghuihan
     * @createTime 2024/2/29 14:18
     * @description 获取当前用户在 指定实例下是否有代办任务：有 返回taskId 没有:返回null
     */
    SignRuTask getMyTask(String signRuId);


    Boolean allTaskComplete(String signRuId);


}