/**
 * @description 签署文档操作管理接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuDocOperate;

import java.util.List;

/**
 * @Description: SignRuDocOperateSerivce
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuDocOperateSerivce
 * @author: FengLai_Gong
 */
public interface SignRuDocOperateService extends IService<SignRuDocOperate> {

    List<SignRuDocOperate> listByRuId(String ruId);

    List<SignRuDocOperate> listByRuIdCurrent(String ruId);

    List<SignRuDocOperate> listByParam(String ruId,String docId);

    List<SignRuDocOperate> listByParamCurrent(String ruId,String docId);

    List<SignRuDocOperate> listByParamCurrent(String ruId,List<String> docIdList);

    SignRuDocOperate getCurrentByDocId(String docId);

    void deleteByParam(List<String> docIdList ,String ruId);
}