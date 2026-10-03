/*
 * @description 资助审批电子签章系统
 */

/**
 * @description: Login interface parameters
 */

import type {  TenantDepartList } from '/#/store';

export interface LoginParams {
  username?: string;
  password?: string;
  checkKey?: number;
  captcha?: string;
  phone?: string | number | null;
  captchaKey?: string;
  type?: string;

}

export interface RoleInfo {
  roleName: string;
  value: string;
}

export interface DeptInfo {
  id:string;
  departName:string;
  orgCode:string;
  [propName: string]: any;
}

/**
 * @description: Login interface return value
 */
export interface LoginResultModel {
  userId: string | number;
  token: string;
  role: RoleInfo;
  departs:DeptInfo;
  username: string;
  multi_depart:number;
  user_tenant_depart:TenantDepartList[]

}

/**
 * @description: Get user information return value
 */
export interface GetUserInfoModel {
  parentId?: any;
  // 密码是否需要修改
  passwordEditFlag?: boolean;
  roles?: RoleInfo[];
  // 用户id
  userId?: string | number;
  // 用户名
  username?: string;
  // 真实名字
  realName?: string;
  // 头像
  avatar?: string;
  // 介绍
  desc?: string;
  // 部门
  departs?:DeptInfo[];
  // 部门数量1 单个 2 多个
  multi_depart?:number,
  user_tenant_depart:TenantDepartList[]

}

/**
 * @description: getAccountList
 */

export interface TenantParams{
  departId:string;
  departName?:string;
}