/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-07-12 16:39:01 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-08-19 14:49:07
 */

import { defHttp } from '/@/utils/http/axios';


enum Api {
  SysLogs = '/api/operateLog/query/page',
  SysLogsInfo = '/api/operateLog/query/info',
  SysErrorLog = '/api/errorLog/query/page',
  SysErrorLogInfo = '/api/errorLog/query/info',
  SysWarningLog = '/api/warningLog/query/page',
  SysWarningLogInfo = '/api/warningLog/query/info',

  LogTypeOperation = '/api/logType/getOperateLogTypeList',
  LogTypeWarning = '/api/logType/getWarningLogTypeLit',
  LogTypeWarningLevel = '/api/logType/getWarningLogLevelList'

 


}


/**
 * @description: 系统日志
 */
export function getSyslog(params) {
  return defHttp.get({ url: Api.SysLogs, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 系统日志详情
 */
export function getSyslogInfo(params) {
  return defHttp.get({ url: Api.SysLogsInfo, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 异常日志
 */
export function getSysErrorlog(params) {
  return defHttp.get({ url: Api.SysErrorLog, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 异常日志详情
 */
export function getSysErrorlogInfo(params) {
  return defHttp.get({ url: Api.SysErrorLogInfo, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 预警日志
 */
export function getSysWarninglog(params) {
  return defHttp.get({ url: Api.SysWarningLog, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 预警日志
 */
export function getSysWarninglogInfo(params) {
  return defHttp.get({ url: Api.SysWarningLogInfo, params }, { errorMessageMode: 'none' });
}


/**
 * @description: 日志操作类型
 */
export function getSysOpeartionType(params) {
  return defHttp.get({ url: Api.LogTypeOperation, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 日志预警类型
 */
export function getSysWarning(params) {
  return defHttp.get({ url: Api.LogTypeWarning, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 日志级别类型
 */
export function getSysWarningLevel(params) {
  return defHttp.get({ url: Api.LogTypeWarningLevel, params }, { errorMessageMode: 'none' });
}

