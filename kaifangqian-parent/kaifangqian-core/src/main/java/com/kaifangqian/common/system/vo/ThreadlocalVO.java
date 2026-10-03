/**
 * @description 线程本地变量
 */
package com.kaifangqian.common.system.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author : zhh
 * create at:  2022/3/16
 */
@Data
public class ThreadlocalVO {
    //流程任务扩展表ID
    private String taskDataId;
    //流程定义ID（activiti）
    private String procDefIdACt;
    //流程实例ID
    private String procInstIdACt;
    //任务ID
    private String taskIdACt;
    //任务key
    private String taskKeyACt;
    //流程定义ID(扩展)
    private String procDefIdExt;
    //业务数据ID
    private String id;

    private boolean paasFlag;

    //complete后路由报错标志位 默认：false  报错后：true
    private boolean completeLineError = false;

    //清空task相关配置标识 删除后置为true(解析xml元素使用)
    private boolean delUserTaskFlag = false;
    private boolean delGatewayFlag = false;
    private boolean delSequenceFlag = false;

    //执行人列表,在线程中临时使用
    private Map<String, List<TaskUserVO>> assigneesMap = new HashMap<>();
    //当前节点运行第几次
    private Map<String, Integer> runFrequency = new HashMap<>();

    private Integer taskInfoType;
    //任务标题
    private String title;
    //任务优先级
    private String priorityLevel;

    private String newTaskDataId;

    private boolean multipleInsDelFlag = false;

    //流程参数
    private Map<String, Object> flowPara = new HashMap<>();
}