/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export enum Api {
  DOC_LIST = '/m1/3157580-0-default/mock/seal/doc/list',
  SealList = '/sign/ent/seal/log/list',
}

export enum SealMakeApi {
  LIST = '/mock/seal/doc/list',
  INFO = '/mock/seal/doc/list',
  DELETE = '/mock/seal/doc/list',
}


export const recordList = (api:Api,params) => defHttp.get({ url: api ,baseURL:"/mock/"});


// recordList(Api.DOC_LIST,{});



/**
 * @description: getUserRolesByDepartId
 */
export function getSealList(params) {
  return defHttp.get({ url: Api.SealList,params }, { errorMessageMode: 'none' });
}


