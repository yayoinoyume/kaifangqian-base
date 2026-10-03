/**
 * @description 获取驱动命令需要信息
 */
package com.kaifangqian.modules.opensign.dto;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/11/15  14:42
 * @description: 获取驱动命令需要信息
 */
@Data
public class TaskCmdInfo {
    private String taskType;
    private String operate;
}