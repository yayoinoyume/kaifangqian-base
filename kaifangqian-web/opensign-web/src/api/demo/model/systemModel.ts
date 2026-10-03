/*
 * @description 资助审批电子签章系统
 */

import { BasicPageParams, BasicFetchResult } from '/@/api/model/baseModel';

export type AccountParams = BasicPageParams & {
  account?: string;
  nickname?: string;
};

export type RoleParams = {
  roleName?: string;
  status?: string;
};

export type RolePageParams = BasicPageParams & RoleParams;

export type DeptParams = {
  deptName?: string;
  status?: string;
  keyWord?: string;
};

export type MenuParams = {
  menuName?: string;
  status?: string;
  id?: string;
  parentId?: string;
};


export interface AccountListItem {
  id: string;
  account: string;
  email: string;
  nickname: string;
  role: number;
  createTime: string;
  remark: string;
  status: number;
}

export interface DeptListItem {
  id: string;
  orderNo: string;
  createTime: string;
  remark: string;
  status: number;
  [x:string]: string | number;
}

export interface MenuListItem {
  id: string;
  orderNo: string;
  createTime: string;
  status: number;
  icon: string;
  component: string;
  permission: string;
}

export interface DeptResultModal {
  result:DeptParams[]
}

export interface MenuBtnItem {
  id: string;
  orderNo: string;
  createTime: string;
  status: number;
  icon: string;
  component: string;
  permission: string;
}

export interface RoleListItem {
  id: string;
  roleName: string;
  roleValue: string;
  status: number;
  orderNo: string;
  createTime: string;
}
export interface RoleUserCountItem {
  id: string;
  roleName: string;
  count:string;
  createTime: string;
}
export interface OrgAuthItem {
  id: string;
  authGroupName: string;
  authName:string;
  desc:string;
  createTime: string;
}

/**
 * @description: Request list return value
 */
export type AccountListGetResultModel = BasicFetchResult<AccountListItem>;

export type DeptListGetResultModel = BasicFetchResult<DeptListItem>;

export type MenuListGetResultModel = BasicFetchResult<MenuListItem>;

export type MenuBtnGetResultModel = BasicFetchResult<MenuBtnItem>
export type MenuBtnGetResultModel = BasicFetchResult<MenuBtnItem>


export type RolePageListGetResultModel = BasicFetchResult<RoleListItem>;

export type RoleListGetResultModel = RoleListItem[];
