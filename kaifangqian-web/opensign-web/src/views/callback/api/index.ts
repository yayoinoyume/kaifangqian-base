/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export enum Api {
  yd_callbackpage = "/yundun/callback/page",
}

export const getCallBackPage = (params) => defHttp.get({ url: Api.yd_callbackpage ,params});
