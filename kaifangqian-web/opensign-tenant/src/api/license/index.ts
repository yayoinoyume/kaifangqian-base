/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export function createTemplateAuth(){
  return defHttp.get({ url: "/sign/authorization/template" });
}


export function createBusinessLineAuth(){
  return defHttp.get({ url: "/sign/authorization/businessLine" });
}

export function getSystemLimit(){
  return defHttp.get({ url: "/sys/systemLimit" });
}

