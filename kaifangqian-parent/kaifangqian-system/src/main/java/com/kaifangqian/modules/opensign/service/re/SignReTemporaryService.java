/**
 * @description 业务临时文件管理类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReTemporary;

import java.util.List;

/**
 * @Description: SignReTemporaryService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReTemporaryService
 * @author: FengLai_Gong
 */
public interface SignReTemporaryService extends IService<SignReTemporary> {

    List<SignReTemporary> listByReId(String reId);
}