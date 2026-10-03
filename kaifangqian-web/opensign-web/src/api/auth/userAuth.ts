/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export function companyQueryApi(params) {
  return defHttp.get({ url: '/system/tenantInfoExtend/enterprise/query', params });
}

export function companyAddApi(params) {
  return defHttp.post({ url: '/system/tenantInfoExtend/enterprise/add', params });
}

export function companyAuthApi(params) {
  return defHttp.post({ url: '/yundun/auth/enterprise/add', params });
}
export function personAuthApi(params: any) {
  return defHttp.post({ url: '/yundun/auth/personal/add', params });
}

export function companyAuthUpdateApi(params: any) {
  return defHttp.post({ url: '/yundun/auth/enterprise/update', params });
}

export function personalAuthUpdateApi(params: any) {
  return defHttp.post({ url: '/yundun/auth/personal/update', params });
}
