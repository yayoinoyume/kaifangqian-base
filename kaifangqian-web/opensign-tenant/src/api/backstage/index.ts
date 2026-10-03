/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  AppList = '/app/list',
  AppAdd = '/app/add',
  AppUpdate = '/app/update',
  DeleteApp = '/app/delete',
  AppInfo = '/app/info',
  AppVersionList = 'app/version/list'
}

/**
 * @description: 应用列表
 */
export function getAppList(params) {
  return defHttp.get({ url: Api.AppList,params });
}
/**
 * @description: 新增应用
 */
export function addApp(params) {
  return defHttp.post({ url: Api.AppAdd,params });
}
/**
 * @description: 删除应用
 */
export function deleteApp(params) {
  return defHttp.delete({ url: Api.DeleteApp,params });
}
/**
 * @description: 编辑应用
 */
export function updateApp(params) {
  return defHttp.post({ url: Api.AppUpdate,params });
}
/**
 * @description: 查询应用信息
 */
export function getAppInfo(params) {
  return defHttp.get({ url: Api.AppInfo, params });
}
/**
 * @description: 查询应用版本
 */
export function getAppVersionList(params) {
  return defHttp.get({ url: Api.AppVersionList, params });
}
