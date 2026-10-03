/*
 * @description 资助审批电子签章系统
 */

//activiti
import { defHttp } from '/@/utils/http/axios';


export function getDefProcess (params){
  return defHttp.get({ url: "/activiti/sysProcessDef/listByProcessCode",params }, { errorMessageMode: 'none' });
}
export function getProcessTodo(params){
  return defHttp.get({ url: "/task/todo/list",params }, { errorMessageMode: 'none' });
}
