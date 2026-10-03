/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-07-04 11:12:17 
 * @Last Modified by: ningw
 * @Last Modified time: 2023-01-16 18:32:54
 */

import { defHttp } from '/@/utils/http/axios';
import { GetUserInfoModel } from './model/userModel';


enum Api {
  UserRoles = '/sys/sysDepart/getUserRolesByDepartId',
  DeptInfoById= '/sys/sysDepart/queryById',
  DeptTree = '/sys/sysDepart/queryTreeList',
  DeptNoCountTree = '/sys/sysDepart/queryMyDeptTreeConcise',
  DeptLevelList = '/sys/sysDepart/queryMyList',
  DeptEdit = '/sys/sysDepart/edit',
  DeptManagerList = '/sys/sysDepart/queryManagerById',
  DeptMyTreeList = '/sys/sysDepart/queryMyDeptTreeList',
  OrganizeAdd = '/sys/sysDepart/addOrganization',
  DeptAllTreeList = '/sys/sysDepart/allDeptTreeConciseForSelect',
  DeptInviteUser = '/sys/sysDepart/inviteUser',
  ReminnUser = '/sys/sysDepart/sendInviteMes',

}


/**
 * @description: getUserRolesByDepartId
 */
export function getUserRoleListByDeptId(params) {
  return defHttp.get<GetUserInfoModel>({ url: Api.UserRoles,params }, { errorMessageMode: 'none' });
}

/**
 * @description: 提醒用户激活
 */
export function remindUser(params) {
  return defHttp.get<GetUserInfoModel>({ url: Api.ReminnUser,params }, { errorMessageMode: 'none' });
}

/**
 * @description: getDeptInfoById
 */
export function getDeptInfoById(params) {
  return defHttp.get({ url: Api.DeptInfoById,params }, { errorMessageMode: 'none' });
}

/**
 * @description: 获取不包含人员数量的组织树
 */
export function getDeptNoCountTree(params) {
  return defHttp.get<GetUserInfoModel>({ url: Api.DeptNoCountTree,params });
}
/**
 * @description: 获取所有部门tree
 */
export function getAllDeptTree() {
  return defHttp.get<GetUserInfoModel>({ url: Api.DeptTree });
}
/**
 * @description: 分层查询部门数据
 */
export function getDeptLevel(params) {
  return defHttp.get({ url: Api.DeptLevelList,params });
}

/**
 * @description: 分层查询部门数据
 */
export function getAllDeptTreeForSelect() {
  return defHttp.get({ url: Api.DeptAllTreeList });
}

/**
 * @description: 我的部门tree
 */
export function getMyDeptTreeList ( params?:{}) {
 return defHttp.get({ url: Api.DeptMyTreeList, params });
}

/**
 * @description: getDeptInfoById
 */
export function editDept(params) {
  return defHttp.put({ url: Api.DeptEdit,params });
}


/**
 * @description: 获取部门主管list
 */
export function getDeptManagerList(params) {
  return defHttp.get({ url: Api.DeptManagerList,params });
}
/**
 * @description: 新增组织
 */
export function addOrganize(params) {
  return defHttp.post({ url: Api.OrganizeAdd,params });
}
/**
 * @description: 新增组织
 */
export function getInviteCode(params) {
  return defHttp.get({ url: Api.DeptInviteUser,params });
}

