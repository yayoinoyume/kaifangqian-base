/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  
  ApplicationUpdateStatus = '/system/sysTenantApp/updateStatus',
  ApplicationUpdateUseful = '/system/sysTenantApp/updateUseful',
  ApplicationInfo = '/system/sysTenantApp/queryById',
  ApplicationList = '/sys/getMyTenantAPPs',
  OpenPersonalTenant = '/system/sysTenantInfo/openPersonalTenant',
  getTenantApp = '/system/sysTenantInfo/getTenantAllApps',
  AddPersonalTenantAppVersion = '/system/sysTenantInfo/addPersonalTenantAppVersion',
  TenantApps = '/system/sysTenantApp/list',
  JionTenant = '/system/sysTenantInfo/jionTenant',
  TenantList = '/system/sysTenantInfo/list',
  TenantStatus = '/system/sysTenantInfo/updateTenantStatus',
}

/**
 * @description: 应用详情
 */
export function getApplicationInfo(params) {
  return defHttp.get({ url: Api.ApplicationInfo,params });
}
/**
 * @description: 停用、启用应用
 */
export function updateAppStatus(params) {
  return defHttp.put({ url: Api.ApplicationUpdateStatus,params });
}
/**
 * @description: 修改范围
 */
export function updateAppUseful(params) {
  return defHttp.put({ url: Api.ApplicationUpdateUseful,params });
}


/**
 * @description: 应用列表
 */
export function getTenantApp(params) {
  return defHttp.get({ url: Api.TenantApps,params });
}
/**
 * @description: 开通个人租户空间
 */
export function openPersonalTenant(params) {
  return defHttp.put({ url: Api.OpenPersonalTenant,params });
}
// /**
//  * @description: 个人应用市场
//  */
// export function getTenantApps(params) {
//   return defHttp.get({ url: Api.getTenantApp,params });
// }
/**
 * @description: 个人租户新增应用
 */
export function addPersonalTenantAppVersion(params) {
  return defHttp.put({ url: Api.AddPersonalTenantAppVersion,params });
}

/**
 * @description: 加入已有企业
 */
export function jionTenant(params) {
  return defHttp.put({ url: Api.JionTenant,params });
}

/**
 * @descript 租户管理列表
 */

export function getTenantList(params){
  return defHttp.get({url: Api.TenantList, params})
}
/**
 * @descript 租户状态管理列表
 */

export function updateTenantStatus(params){
  return defHttp.put({url: Api.TenantStatus, params})
}

export function setTenantBType(params){
  return defHttp.put({url: "/system/sysTenantInfo/setTenantBType", params})
}
