/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-28 14:32:55 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-07-21 18:47:01
 */
import { defHttp } from '/@/utils/http/axios';

enum Api {
  TaskList = '/job/list',
  TaskSave = '/job/save',  //新建、编辑、启用
  TaskDisabled = '/job/disable',  //禁用
  TaskDelete = '/job/delete',
  TaskRun = '/job/run',  
  TaskCopy = '/job/copy',   

  InstanceList = '/instance/list',
  InstanceLog = '/instance/log',
  InstanceStop= '/instance/stop',
  InstanceRetry= '/instance/retry',
  InstanceDetail= '/instance/detail',

}




/**
 * @description: 任务列表
 */
export function getTaskList(params) {
  return defHttp.get({ url: Api.TaskList,params });
}

/**
 * @description: 禁用任务
 */
 export function disabledTask(params) {
  return defHttp.get({ url: Api.TaskDisabled,params });
}
/**
 * @description: 启用任务
 */
 export function runTask(params) {
  return defHttp.get({ url: Api.TaskRun,params });
}
/**
 * @description: 删除任务
 */
 export function deleteTask(params) {
  return defHttp.get({ url: Api.TaskDelete,params });
}

/**
 * @description: 新建、编辑、启用任务
 */
export function addTaskList(params) {
  return defHttp.post({ url: Api.TaskSave,params });
}


/**
 * @description: 任务实例列表
 */
export function getaskInstance(params) {
  return defHttp.get({ url: Api.InstanceList,params });
}


/**
 * @description: 任务实例日志
 */
export function getInstanceLog(params) {
  return defHttp.get({ url: Api.InstanceLog,params });
}
/**
 * @description: 任务实例停止
 */
export function setInstanceStop(params) {
  return defHttp.get({ url: Api.InstanceStop,params });
}
/**
 * @description: 任务实例重试
 */
export function setInstanceRetry(params) {
  return defHttp.get({ url: Api.InstanceRetry,params });
}
/**
 * @description: 任务实例详情
 */
export function getInstanceDetail(params) {
  return defHttp.get({ url: Api.InstanceDetail,params });
}







