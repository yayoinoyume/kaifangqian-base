/**
 * @description 业务线分类接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReFolderRelation;

import java.util.List;

/**
 * @Description: SignReFolderRelationService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReFolderRelationService
 * @author: FengLai_Gong
 */
public interface SignReFolderRelationService extends IService<SignReFolderRelation> {

    List<String> getReIdList(String reFolderId);

    List<SignReFolderRelation> getList(String folderId, List<String> reIdList);

    String getFolderId(String reId);

    Integer count(String folderId);

    Integer count(List<String> folderIdList);


    Boolean delete(String folderId,List<String> reIdList);


    Boolean deleteRelation(String reId);

    Boolean deleteRelation(List<String> reIdList);


}