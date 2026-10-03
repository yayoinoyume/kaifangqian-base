/**
 * @description 模板分类数据接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateFolder;

import java.util.List;

/**
 * @Description: SignTemplateFolderService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateFolderService
 * @author: FengLai_Gong
 */
public interface SignTemplateFolderService extends IService<SignTemplateFolder> {


    Integer countChildren(String folderId);


    Integer countChildren(List<String> folderIdList);


    void delete(List<String> folderIdList);

}