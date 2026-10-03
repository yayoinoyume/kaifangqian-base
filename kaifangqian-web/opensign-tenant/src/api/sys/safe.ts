/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-07-12 16:39:01 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-08-08 19:25:49
 */

import { defHttp } from '/@/utils/http/axios';


enum Api {
  SafeSensitive = '/api/monitorConfig/list',
  SafeSensitiveAdd = '/api/monitorConfig/add',
  SafeSensitiveEdit = '/api/monitorConfig/edit',
  SafeSensitiveDelete = '/api/monitorConfig/deleteBatch',
  SafeIpList = '/api/monitorBlacklist/info',
  SafeIpAdd = '/api/monitorBlacklist/add',
  SafeIpEdit = '/api/monitorBlacklist/edit',

  SafeConfig = '/api/sysConfig',
  SysConfigNoAuth = '/api/sysConfig/passwordComposition',
  SysConfigPasswordLength = '/api/sysConfig/passwordMinimumLen',

 


}


/**
 * @description: 敏感操作列表
 */
export function getSensitiveList(params) {
  return defHttp.get({ url: Api.SafeSensitive, params }, { errorMessageMode: 'none' });
}

/**
 * @description: 配置敏感操作
 */
export function addSensitive(params) {
  return defHttp.post({ url: Api.SafeSensitiveAdd, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 更新敏感操作
 */
export function updateSensitive(params) {
  return defHttp.put({ url: Api.SafeSensitiveEdit, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 删除敏感操作
 */
export function deleteSensitive(params) {
  return defHttp.delete({ url: Api.SafeSensitiveDelete, params }, { errorMessageMode: 'none' });
}


/**
 * @description: 限制ip 列表
 */
export function getIpList(params) {
  return defHttp.get({ url: Api.SafeIpList, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 新增限制ip 列表
 */
export function addIpLimit(params) {
  return defHttp.post({ url: Api.SafeIpAdd, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 编辑限制ip 列表
 */
export function updateIpList(params) {
  return defHttp.put({ url: Api.SafeIpEdit, params }, { errorMessageMode: 'none' });
}

export function getSafeConfig (params) {
  return defHttp.get({url:Api.SafeConfig,params})
}

export function setSafeConfig (params) {
  return defHttp.post({url:Api.SafeConfig,params})
}

export function getSystemPasswordConfig (params) {
  return defHttp.get({url:Api.SysConfigNoAuth,params})
}
export function getSystemPasswordLength () {
  return defHttp.get({url:Api.SysConfigPasswordLength})
}

