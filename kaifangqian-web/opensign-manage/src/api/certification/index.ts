/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  EnterpriseCerList = '/cert/operation/manage/enterprise/list',
  PersonaliseCerList = '/cert/operation/manage/personal/list',
 
}

/**
 * @description: 企业证书列表
 */
export function getEnterpriseCerList(params) {
  return defHttp.get({ url: Api.EnterpriseCerList,params });
}
/**
 * @description: 个人证书列表
 */
export function getPersonaliseCerList(params) {
  return defHttp.get({ url: Api.PersonaliseCerList,params });
}