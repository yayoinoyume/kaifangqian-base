/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export function quickQueryApi(params) {
  return defHttp.get({ url: '/yundun/sign/willingnesss/service/info/query', params });
}
export function quickRecordQueryApi(params) {
  return defHttp.get({ url: '/yundun/sign/willingnesss/service/record/query', params });
}

export function quickOpenApi(params) {
  return defHttp.post({ url: '/yundun/sign/willingnesss/service/open', params });
}

export function quickCloseApi(params) {
  return defHttp.post({ url: '/yundun/sign/willingnesss/service/close', params });
}
