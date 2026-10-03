/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

const testResult = {
  code:200,
  result:true,
  message:"",
}
export function createTemplateAuth(){
  // return defHttp.get({ url: "/system/sysAuthGroup/listMy",params }, { errorMessageMode: 'none' });
  testResult.message = "只能创建N个模板";
  return testResult
}


export function createBusinessLineAuth(){
  testResult.message = "只能创建N个业务线";
  return testResult
}

export function createAuthorizationAuth(){
  testResult.message = "只能创建N个接口授权凭证";
  return testResult
}

export function getSystemLimit(){
  return defHttp.get({ url: "/sys/systemLimit" });
}

