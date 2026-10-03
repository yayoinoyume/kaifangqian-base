/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

import { useUserStore } from '/@/store/modules/user';
const userStore = useUserStore();
const tenantInfo = userStore.getTenantInfo;
let listType ='';
if(tenantInfo.tenantType=='1'){
  listType = '/company'
}else{
  listType = '/personal'
}

enum  Api{

  DraftList =  '/task/listDraft',
  SendList = '/task/listSend',
  PendingMyList = '/task/listMyJob',
  BoxList = '/task/listInbox',
  CopyMeList = '/task/listCopyMe',
  RecycleMeList = '/task/listRecycle',
  AllList = '/task/listAll',
  OtherJobList = '/task/listOtherJob',
  RunningList = '/task/listRunning',
  FinishList = '/task/listFinish',
  InvalidList = '/task/listInvalid',
  checkOperate = '/company/task/checkOperate',
}

/**
 * @description: 获取已发送
 */
export function getCompanySendList(params) {
  return defHttp.get({ url: listType + Api.SendList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 获取草稿
 */
export function getCompanyDraftList(params) {
  return defHttp.get({ url:  listType + Api.DraftList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 收件箱
 */
export function getCompanyBoxList(params) {
  return defHttp.get({ url:  listType + Api.BoxList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 抄送我的
 */
export function getCompanyCopyMeList(params) {
  return defHttp.get({ url:  listType + Api.CopyMeList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 回收站
 */
export function getCompanyRecycleMeList(params) {
  return defHttp.get({ url:  listType + Api.RecycleMeList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 全部文档
 */
export function getCompanyAllList(params) {
  return defHttp.get({ url:  listType + Api.AllList,params }, { errorMessageMode: 'none' });
}

/**
 * @description: 待我处理
 */
export function getPendingList(params) {
  return defHttp.get({ url:  listType + Api.PendingMyList,params }, { errorMessageMode: 'none' });
}

/**
 * @description: 待他人处理
 */
export function getOtherJobList(params) {
  return defHttp.get({ url:  listType + Api.OtherJobList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 未完成
 */
export function getRunningList(params) {
  return defHttp.get({ url:  listType + Api.RunningList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 已完成
 */
export function getFinishList(params) {
  return defHttp.get({ url:  listType + Api.FinishList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 已失效
 */
export function getInvalidList(params) {
  return defHttp.get({ url:  listType + Api.InvalidList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 获取列表操作
 */
export function getCheckOperates(params) {
  return defHttp.get({ url: Api.checkOperate,params }, { errorMessageMode: 'none' });
}
