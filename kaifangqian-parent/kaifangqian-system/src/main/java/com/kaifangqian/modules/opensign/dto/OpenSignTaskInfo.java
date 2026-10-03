/**
 * @description 签署流程节点信息
 */
package com.kaifangqian.modules.opensign.dto;

import lombok.Data;

import java.util.Map;

/**
 * @author : zhenghuihan
 * create at:  2023/11/7  15:27
 * @description: 签署流程节点信息
 */
@Data
public class OpenSignTaskInfo {
    private Integer order;
    private String type;
    /**
     * 同意：approve  拒绝：reject
     */
    private Map<String, String> operateMap;
    private String nextTaskType;
}