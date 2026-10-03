/**
 * @Discription:文件存储
 */
package com.kaifangqian.modules.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhenghuihan
 * create at:  2022/9/28  17:48
 * @description: 附件dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto {
    private String id;
    private String realName;

    public StorageDto(String id) {
        this.id = id;
    }
}