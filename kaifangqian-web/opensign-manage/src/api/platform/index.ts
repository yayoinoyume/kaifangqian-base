/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

/**
 * @description: 获取logobase64
 */
export function getLogoBase64(params) {
  return defHttp.get({ url: "/downloadFileBase64Type/"+params});
}