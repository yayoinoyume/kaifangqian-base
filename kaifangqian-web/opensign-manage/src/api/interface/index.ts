/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

 
/**
 * @description: 开发者列表
 */
export function developerManageList(params) {
  return defHttp.get({ url: "/system/developerManage/list",params });
}

 
/**
 * @description: 新增开发者
 */
export function developerManageAdd(params) {
  return defHttp.post({ url: "/system/developerManage/add",params });
}



/**
 * @description: 编辑开发者
 */
export function developerManageEdit(params) {
  return defHttp.put({ url: "/system/developerManage/edit",params });
}