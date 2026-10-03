/**
 * @description 模板分类数据关联接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateFolderRelation;

import java.util.List;

/**
 * @Description: SignTemplateFolderRelationService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateFolderRelationService
 * @author: FengLai_Gong
 */
public interface SignTemplateFolderRelationService extends IService<SignTemplateFolderRelation> {


    List<String> getTemplateIdList(String templateFolderId);

    List<SignTemplateFolderRelation> getList(String folderId,List<String> templateIdList);


    Integer count(String folderId);

    Integer count(List<String> folderIdList);


    Boolean delete(String folderId,List<String> templateIdList);


    Boolean deleteRelation(String templateId);

    Boolean deleteRelation(List<String> templateIdList);


}