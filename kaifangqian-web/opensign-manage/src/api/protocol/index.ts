/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2023-10-25 16:39:01 
 * @Last Modified by: ningw
 * @Last Modified time: 2023-10-25 17:46:01
 */

import { defHttp } from '/@/utils/http/axios';


enum Api {
  ProtocolInfo = '/sys/sysTextConfig/info',
  ProtocolInfoByToken = '/sys/sysTextConfig',
  ProtocolSet = '/sys/sysTextConfig',
 

 


}


/**
 * @description: 服务协议获-无token
 */
export function getProtocolInfo(params) {
  return defHttp.get({ url: Api.ProtocolInfo, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 服务协议获取带token
 */
export function getProtocolInfoByToken(params) {
  return defHttp.get({ url: Api.ProtocolInfoByToken, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 服务协议获取带token
 */
export function setProtocol(params) {
  return defHttp.post({ url: Api.ProtocolSet, params }, { errorMessageMode: 'none' });
}