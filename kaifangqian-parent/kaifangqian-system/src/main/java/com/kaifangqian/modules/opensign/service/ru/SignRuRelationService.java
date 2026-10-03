/**
 * @description 获取签署文档操作关联人接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuRelation;

import java.util.List;

/**
 * @Description: SignRuRelationService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuRelationService
 * @author: FengLai_Gong
 */
public interface SignRuRelationService extends IService<SignRuRelation> {
    List<SignRuRelation> getNoUserList(SignRuRelation query);


    List<SignRuRelation> getByEntity(SignRuRelation query);
}