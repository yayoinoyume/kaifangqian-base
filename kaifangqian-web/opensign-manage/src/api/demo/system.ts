/*
 * @description 资助审批电子签章系统
 */

import {
  AccountParams,
  DeptListItem,
  MenuParams,
  RoleParams,
  RolePageParams,
  MenuListGetResultModel,
  DeptListGetResultModel,
  AccountListGetResultModel,
  RolePageListGetResultModel,
  RoleUserCountItem,
  OrgAuthItem,
  RoleListGetResultModel,
  MenuBtnGetResultModel,
  DeptParams,
  DeptResultModal,
} from './model/systemModel';
import { defHttp } from '/@/utils/http/axios';

enum Api {
  AccountList = '/system/getAccountList',
  IsAccountExist = '/system/accountExist',
  
  DeptLevelList = '/sys/sysDepart/queryList',
  DeptMyWidthCountList = '/sys/sysDepart/queryMyDeptTreeList',
  DeptUserList = '/sys/sysDepart/getUsersByDepartId',   
  DepartUserList  = '/sys/sysDepart/getUserListByDepartId',

  DeptMyByKeyword = '/sys/sysDepart/searchMyBy',
  RoleMyByKeyword = '/sys/role/searchMyBy',
  UserMyByKeyword = '/sys/user/searchMyBy',

  DeptAdd = '/sys/sysDepart/add',
  DeptUpdate = '/sys/sysDepart/edit',

  
  setRoleStatus = '/system/setRoleStatus',
  MenuList = '/sys/permission/listMenu',
  MenuCatalogue = '/sys/permission/listCatalogue',
  MenuBtnList = '/sys/permission/getMenuList',
  AddMenu  = '/sys/permission/add',
  updateMenu  = '/sys/permission/edit',
  deleteMenu  = '/sys/permission/delete',
  RolePageList = '/system/getRoleListByPage',
  GetAllRoleList = '/system/getAllRoleList',
  RoleUserCount = '/system/getRoleUserCount',
  OrgAuthList = '/system/getOrgAuthList',
  operationLoglist = '/system/getOperationList',
  abnormalLoglist = '/system/getAbnormalList',
  securityList = '/system/getSecurityList',
  safeSetting = '/system/getSafeSetting',
  msgTplTreeList = '/system/getMsgTplTreeList',
  msgTplList = '/system/getMsgTplList',
  myMessage = '/system/getMyMessage',
  announceTreeList = '/system/getAnnounceTreeList',
  announceList = '/system/getAnnounceList',
  authGroupList = '/system/getAuthGroupList',
  authUserList = '/system/getAuthUserList',

}

export const getAccountList = (params: AccountParams) =>
  defHttp.get<AccountListGetResultModel>({ url: Api.AccountList, params });

export const getDeptTreeList = (params?: DeptListItem) =>
  defHttp.get({ url: Api.DeptMyWidthCountList, params });

export const getDeptLevelList = (params?: DeptListItem) =>
  defHttp.get<DeptListGetResultModel>({ url: Api.DeptLevelList, params });

export const getMsgTplTreeList = (params?: DeptListItem) =>
  defHttp.get({ url: Api.msgTplTreeList, params });

export const getMenuList = (params?: MenuParams) =>
  defHttp.get<MenuListGetResultModel>({ url: Api.MenuList, params });

export const getCatalogueMenuList = (params?: MenuParams) =>
  defHttp.get<MenuListGetResultModel>({ url: Api.MenuCatalogue, params });

  
export const getMenuBtnList = (params?: MenuParams) =>
  defHttp.get<MenuBtnGetResultModel>({ url: Api.MenuBtnList, params });

  
export const getDeptByKeywordList = (params) =>
  defHttp.get({ url: Api.DeptMyByKeyword, params });

  
export const getUserByKeywordList = (params) =>
  defHttp.get({ url: Api.UserMyByKeyword, params });

  
export const getRoleByKeywordList = (params) =>
  defHttp.get({ url: Api.RoleMyByKeyword, params });

  
export const DeptAdd = (params?: DeptParams) =>
  defHttp.post<DeptResultModal>({ url: Api.DeptAdd, params });

  
export const DeptUpdate = (params?: DeptParams) =>
  defHttp.put<DeptResultModal>({ url: Api.DeptUpdate, params });

  
export const setMenu = (params?: MenuParams) =>
  defHttp.post({ url: Api.AddMenu, params})

export const updateMenu = (params?: MenuParams) =>
  defHttp.post({ url: Api.updateMenu, params})

export const deleteMenu = (params?: MenuParams) =>
  defHttp.delete({ url: Api.deleteMenu, params})

  /**
   * @desc 弹框选人根据组织查人
   * @param params 
   * @returns 
   */
export const getUserList = (params?: MenuParams) =>
  defHttp.get({ url: Api.DeptUserList, params });

  /**
   * @desc 组织管理根据组织查人
   * @param params 
   * @returns 
   */
export const getUserForOrgList = (params?: MenuParams) =>
  defHttp.get({ url: Api.DepartUserList, params });
  

export const getTplList = (params?: MenuParams) =>
  defHttp.get({ url: Api.msgTplList, params });

export const getOperationList = (params?: MenuParams) =>
  defHttp.get({ url: Api.operationLoglist, params });

export const getAnnounceTreeList = (params?: MenuParams) =>
  defHttp.get({ url: Api.announceTreeList, params });

export const getAuthGroupList = (params?: MenuParams) =>
  defHttp.get({ url: Api.authGroupList, params });

export const getAuthUserList = (params?: MenuParams) =>
  defHttp.get({ url: Api.authUserList, params });

export const getAnnounceList = (params?: MenuParams) =>
  defHttp.get({ url: Api.announceList, params });

export const getAbnormalList = (params?: MenuParams) =>
  defHttp.get({ url: Api.abnormalLoglist, params });
  
export const getSecurityList = (params?: MenuParams) =>
  defHttp.get({ url: Api.securityList, params });


export const getSafeSetting = (params?: MenuParams) =>
  defHttp.get({ url: Api.safeSetting, params });

export const getMyMessagelist = (params?: MenuParams) =>
  defHttp.get({ url: Api.myMessage, params });
  
export const getRoleUserCount = (params?: MenuParams) =>
  defHttp.get<RoleUserCountItem>({ url: Api.RoleUserCount, params });

export const getOrgAuthList = (params?: MenuParams) =>
  defHttp.get<OrgAuthItem>({ url: Api.OrgAuthList, params });

export const getRoleListByPage = (params?: RolePageParams) =>
  defHttp.get<RolePageListGetResultModel>({ url: Api.RolePageList, params });

export const getAllRoleList = (params?: RoleParams) =>
  defHttp.get<RoleListGetResultModel>({ url: Api.GetAllRoleList, params });

export const setRoleStatus = (id: number, status: string) =>
  defHttp.post({ url: Api.setRoleStatus, params: { id, status } });



export const isAccountExist = (account: string) =>
  defHttp.post({ url: Api.IsAccountExist, params: { account } }, { errorMessageMode: 'none' });
