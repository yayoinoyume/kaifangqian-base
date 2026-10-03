/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';


export function getFormColumn (params){
  return defHttp.get({ url: "/form/authority/getFormAuth",params }, { errorMessageMode: 'none' });
}
