/**
 * @description 业务临时文件管理类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReTemporaryImage;

import java.util.List;

/**
 * @Description: SignReTemporaryImageService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReTemporaryImageService
 * @author: FengLai_Gong
 */

public interface SignReTemporaryImageService extends IService<SignReTemporaryImage> {


    List<SignReTemporaryImage> listByTemporaryId(String temporaryId);
}