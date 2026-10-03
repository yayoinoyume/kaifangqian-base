/**
 * @description 签署附件服务接口类
 */
package com.kaifangqian.modules.opensign.service.annex;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.AnnexImage;

import java.util.List;

/**
 * @Description: SignRuDocImageService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuDocImageService
 * @author: FengLai_Gong
 */
public interface AnnexImageService extends IService<AnnexImage> {

    List<AnnexImage> listByAnnexId(String annexId);

    Integer countByAnnexId(String annexId);

}