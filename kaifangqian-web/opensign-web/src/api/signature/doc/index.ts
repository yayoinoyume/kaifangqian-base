/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  DOC_LIST = '/m1/3157580-0-default/mock/seal/doc/list',
  TemplateInfo  = 'sign/template/info/apply'
}


export const getDocList = () => defHttp.get({ url: Api.DOC_LIST ,baseURL:"/mock/"});


export const getDocInfo = (params) => defHttp.get({ url: Api.TemplateInfo, params});



