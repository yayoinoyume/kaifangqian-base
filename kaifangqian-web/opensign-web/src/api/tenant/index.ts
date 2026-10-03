/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  ApplicationList = '/sys/getMyTenantAPPs',
  OpenPersonalTenant = '/system/sysTenantInfo/openPersonalTenant',
  getTenantApps = '/system/sysTenantInfo/getTenantAllApps',
  AddPersonalTenantAppVersion = '/system/sysTenantInfo/addPersonalTenantAppVersion',
  JionTenant = '/system/sysTenantInfo/jionTenant',
  RegisterTenant = '/system/tenantInfoExtend/tenantRegister',
  RegisterPersonalTenant = '/sys/personalTenantRegister',
  RegisterTenantAuth = '/copyright/tenantInfoExtend/submitAuth',
  RegisterTenantInfo = '/copyright/tenantInfoExtend/queryById',
  QuickAppTree = '/copyright/tenantInfoExtend/queryById',
  
}

/**
 * @description: 应用列表
 */
export function getApplication(params) {
  return defHttp.get({ url: Api.ApplicationList,params });
}
/**
 * @description: 快捷操作应用列表
 */
export function getQuickAppTree(params) {
  return defHttp.get({ url: Api.QuickAppTree,params });
}
/**
 * @description: 开通个人租户空间
 */
export function openPersonalTenant(params) {
  return defHttp.put({ url: Api.OpenPersonalTenant,params });
}
/**
 * @description: 个人应用市场
 */
export function getTenantApps(params) {
  return defHttp.get({ url: Api.getTenantApps,params });
}
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
  return defHttp.put({ url: Api.JionTenant,params},{ errorMessageMode: 'none', isReturnNativeResponse:true });
}
/**
 * @description: 租户注册
 */
export function registerTenant(params) {
  return defHttp.put({ url: Api.RegisterTenant,params });
}
/**
 * @description: 租户实名认证
 */
export function registerTenantAuth(params) {
  return defHttp.post({ url: Api.RegisterTenantAuth,params });
}
/**
 * @description: 租户实名认证详情
 */
export function registerTenantInfo(params) {
  return defHttp.get({ url: Api.RegisterTenantInfo,params });
}