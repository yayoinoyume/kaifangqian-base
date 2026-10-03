/**
 * @description 签署文档管理接口类
 */
package com.kaifangqian.modules.opensign.service.doc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignDocControl;

import java.util.List;

/**
 * @Description: SignDocControlService
 * @Package: com.kaifangqian.modules.opensign.service.doc
 * @ClassName: SignDocControlService
 * @author: FengLai_Gong
 */
public interface SignDocControlService extends IService<SignDocControl> {

    Integer count(String docId);

    List<SignDocControl> getList(String docId);


    void delete(String docId);
}