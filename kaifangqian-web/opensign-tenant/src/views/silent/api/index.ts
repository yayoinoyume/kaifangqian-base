/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

/**
 *
 *
 * @param params
 * @returns
 */
export function silentQueryApi(params) {
  return defHttp.get({ url: '/yundun/sign/silent/service/info/query', params });
}

export function silentQueryRecordApi(params) {
  return defHttp.get({ url: '/yundun/sign/silent/service/record/query', params });
}
export function silentOpenApi(params) {
  return defHttp.post({ url: '/yundun/sign/silent/service/open', params });
}

export function silentCloseApi(params) {
  return defHttp.post({ url: '/yundun/sign/silent/service/close', params });
}
