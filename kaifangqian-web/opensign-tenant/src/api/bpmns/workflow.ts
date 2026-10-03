/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-28 14:32:55 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-07-21 17:20:16

*/
import { defHttp } from '/@/utils/http/axios';

enum Api {
  //字典分组
  DictTree = '/sys/dict/treeList',

}

export function checkFlow (url,params){
  return defHttp.post({ url: url,params }, { errorMessageMode: 'none' });
}

export function getFlowType (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function noticeConfigList (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function createOutsideFlow (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function updateOutsideFlow (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function createInsideFlow (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function updateInsideFlow (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}