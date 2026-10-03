/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export function companyAuthApi(params) {
  return defHttp.post({ url: '/yundun/auth/enterprise/add', params });
}

export function companyAuthUpdateApi(params: any) {
  return defHttp.post({ url: '/yundun/auth/enterprise/update', params });
}
