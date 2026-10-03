/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  LineList = '/sys/dict/treeList',
  LineCategoryTree = '/sys/dict/treeList',
  LineConfigInfo = '/sys/dict/treeList',
  LineConfigSave = '/sys/dict/treeList',
}
/**
 * @description: 业务线分组列表
 */
export function getLineTree(params) {
  return defHttp.get({ url: Api.LineCategoryTree,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 业务线列表
 */
export function getBusinessLine(params) {
  return defHttp.get({ url: Api.LineList,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 业务线配置信息
 */
export function getLineConfigInfo(params) {
  return defHttp.get({ url: Api.LineConfigInfo,params }, { errorMessageMode: 'none' });
}

/**
 * @description: 保存业务线配置信息
 */
export function saveLineConfig(params) {
  return defHttp.post({ url: Api.LineConfigSave,params }, { errorMessageMode: 'none' });
}