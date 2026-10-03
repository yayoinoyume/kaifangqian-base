/**
 * @description 业务线签署文件接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReDoc;

import java.util.List;

/**
 * @Description: SignReDocService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReDocService
 * @author: FengLai_Gong
 */
public interface SignReDocService extends IService<SignReDoc> {

    List<SignReDoc> listByReId(String reId);


    void deleteByParam(List<String> idList,String reId);
}