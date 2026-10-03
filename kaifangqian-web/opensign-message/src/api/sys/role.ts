/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-28 14:32:55 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-09-09 15:29:26
 */
import { defHttp } from '/@/utils/http/axios';
import { RoleList } from './model/roleModel';
// import { ErrorMessageMode } from '/#/axios';

enum Api {
  RoleGroupList = '/sys/role/listGroup',
  RoleMyGroupList = '/sys/role/myRoleGroup',
  RoleListByGroupId = '/sys/role/listRole',
  RoleTreeList = '/sys/role/allRoleTree',
  RoleMyTreeList = '/sys/role/myRoleTree',
  RoleUserlist = '/sys/role/getUsersByRoleId',
  RoleAdd = '/sys/role/add',
  RoleEdit = '/sys/role/edit',
  RoleDelete = '/sys/role/delete',
  RoleBatchDelete = '/sys/role/deleteBatch',
  RoleUserList = '/sys/role/getUsersByRoleId',
  RoleInfo = '/sys/role/queryById',
  RoleRemoveBatch = '/sys/role/removeBatch',
  RoleAddUser = '/sys/role/addRoleUser',
  RoleAllTreeForSelect = '/sys/role/allRoleTreeForSelect'

}


/**
 * @description: 获取角色组
 */

export function getRoleGroupList() {
  return defHttp.get({ url: Api.RoleGroupList });
}
/**
 * @description: 获取我的角色组
 */

export function getMyRoleGroupList() {
  return defHttp.get({ url: Api.RoleMyGroupList });
}
/**
 * @description: 获取角色组下的角色
 */

export function getRoleList(params) {
  return defHttp.get({ url: Api.RoleListByGroupId, params });
}
/**
 * @description:  用于反显的角色树
 */

export function getAllRoleTreeListForSelect() {
  return defHttp.get({ url: Api.RoleAllTreeForSelect });
}

export function getRoleTreeList() {
  return defHttp.get({ url: Api.RoleTreeList });
}
export function getMyRoleTreeList() {
  return defHttp.get({ url: Api.RoleMyTreeList });
}

export function getUserByRoleId(params) {
  return defHttp.get<RoleList>({ url: Api.RoleUserList,params });
}

export function addRole(params) {
  return defHttp.post({ url: Api.RoleAdd, params });
}

export function updateRole(params) {
  return defHttp.post<RoleList>({ url: Api.RoleEdit,params });
}

export function deleteRole(params) {
  return defHttp.post<RoleList>({ url: Api.RoleDelete,params });
}

export function getRoleInfo(params) {
  return defHttp.get({ url: Api.RoleInfo,params });
}
export function removeUserBatch(params) {
  return defHttp.delete({ url: Api.RoleRemoveBatch,params });
}

export function addUserToRole(params) {
  return defHttp.post({ url: Api.RoleAddUser,params });
}
