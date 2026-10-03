/**
 * @description 业务线文件夹管理接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReFolder;

import java.util.List;

/**
 * @Description: SignReFolderService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReFolderService
 * @author: FengLai_Gong
 */
public interface SignReFolderService extends IService<SignReFolder> {

    Integer countChildren(List<String> folderIdList);


    void delete(List<String> folderIdList);


}