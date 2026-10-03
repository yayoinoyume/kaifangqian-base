/**
 * @Discription:文件存储接口类
 */
package com.kaifangqian.modules.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.storage.dto.StorageDto;
import com.kaifangqian.modules.storage.entity.AnnexStorage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IAnnexStorageService extends IService<AnnexStorage> {
    String create(AnnexStorage annexStorage, MultipartFile file);

    String createBase64(MultipartFile file);

    String create(byte[] file, String dataCategory, String originalFilename, long fileSize, String fatherId);

    String create(String base64, String fatherId, String dataCategory, String originalFilename);

    void deleteExt(String id);

    List<AnnexStorage> getByEntity(AnnexStorage annexStorage);

    List<StorageDto> getByFatherId(String fatherId);

    List<AnnexStorage> getByFatherIds(List<String> fatherIds);

    List<AnnexStorage> getByFatherIdsAndType(List<String> fatherIds, String dataCategory);

    void updateMainDataFiles(String fatherId, List<StorageDto> files);

    void updateMainDataFilesByType(String fatherId, String dataCategory, List<StorageDto> files);
}
