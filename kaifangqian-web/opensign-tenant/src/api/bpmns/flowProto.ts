/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-28 14:32:55 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-07-21 17:28:26

*/
import { defHttp } from '/@/utils/http/axios';

enum Api {
  DictTree = '/sys/dict/treeList',

}



export function postAction (url,params){
  return defHttp.post({ url: url,params }, { errorMessageMode: 'none' });
}

export function updateProcessConfig (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function triggerClass (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}
export function queryProcessConfig (url,params){
  return defHttp.get({ url: url,params }, { errorMessageMode: 'none' });
}