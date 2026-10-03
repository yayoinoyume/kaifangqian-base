/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-28 14:32:55 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-09-28 17:32:45

*/
import { defHttp } from '/@/utils/http/axios';

enum Api {
  //字典分组
  DictTree = '/sys/dict/treeList',
  DictGroupAdd = '/sys/dict/add',
  DictGroupEdit = '/sys/dict/edit',
  DictGroupInfo = '/sys/dict/info',
  DictGroupDelete = '/sys/dict/delete',
  //字典值
  DictItems = '/sys/dictItem/list',
  DictTreeItems = '/sys/dictItem/treeList',
  DictItemAdd = '/sys/dictItem/add',
  DictItemEdit = '/sys/dictItem/edit',
  DictItemDelete = '/sys/dictItem/delete',

  //单号
  OrderNumberList = '/globalId/list',
  OrderNumberAdd = '/globalId/add',
  OrderNumberDelete = '/globalId/delete',
  OrderNumberEdit = '/globalId/edit',
  OrderNumberGenerate = '/globalId/testByKey',
  OrderNumberRuleInfo = '/globalId/getInfoById',

  //系统校验规则
  VerifyList = '/sys/checkRule/list',
  VerifyAdd = '/sys/checkRule/add',


}


/**
 * @description: 获取数据字典树
 */
export function getDictTree(params) {
  return defHttp.get({ url: Api.DictTree,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 新增数据字典组
 */
export function addDictGroup(params) {
  return defHttp.post({ url: Api.DictGroupAdd,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 获取数据字典树
 */
export function editDictGroup(params) {
  return defHttp.post({ url: Api.DictGroupEdit,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 字典分类和字典详情
 */
export function getDictInfo(params) {
  return defHttp.get({ url: Api.DictGroupInfo,params }, { errorMessageMode: 'none' });
}
/**
 * @description: 删除数据字典树
 */
export function deleteDictGroup(params) {
  return defHttp.delete({ url: Api.DictGroupDelete,params }, { errorMessageMode: 'none' });
}

/**
 * @description: 获取数据字典值
 */
export function getDictItems(params) {
  return defHttp.get({ url: Api.DictItems, params}, { errorMessageMode: 'none' });
}
/**
 * @description: 获取数据字典值tree结构
 */
export function getDictTreeItems(params) {
  return defHttp.get({ url: Api.DictTreeItems, params}, { errorMessageMode: 'none' });
}

/**
 * @description: 新增字典值
 */
export function addDictItem(params) {
  return defHttp.post({ url: Api.DictItemAdd, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 编辑字典值
 */
export function editDictItem(params) {
  return defHttp.post({ url: Api.DictItemEdit, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 删除字典值
 */
export function deleteDictItem(params) {
  return defHttp.delete({ url: Api.DictItemDelete, params }, { errorMessageMode: 'none' });
}


/**
 * @description: 单号列表
 */
export function getOrderNumber(params) {
  return defHttp.get({ url: Api.OrderNumberList, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 新增单号
 */
export function addOrderNumber(params) {
  return defHttp.post({ url: Api.OrderNumberAdd, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 编辑单号
 */
export function editOrderNumber(params) {
  return defHttp.put({ url: Api.OrderNumberEdit, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 删除单号
 */
export function deleteOrderNumber(params) {
  return defHttp.delete({ url: Api.OrderNumberDelete, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 获取单号规则配置列表
 */
export function getOrderNumberRule(params) {
  return defHttp.get({ url: Api.OrderNumberRuleInfo, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 单号测试 
 */
export function generateOrderNumber(params) {
  return defHttp.get({ url: Api.OrderNumberGenerate, params }, { errorMessageMode: 'none' });
}

/**
 * @description: 系统校验规则列表
 */
export function getCheckRuleList(params) {
  return defHttp.get({ url: Api.VerifyList, params }, { errorMessageMode: 'none' });
}
/**
 * @description: 系统校验规则新增
 */
export function addCheckRuleList(params) {
  return defHttp.post({ url: Api.VerifyAdd, params }, { errorMessageMode: 'none' });
}

