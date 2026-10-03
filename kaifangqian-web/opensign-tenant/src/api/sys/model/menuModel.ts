/*
 * @description 资助审批电子签章系统
 */

import type { RouteMeta } from 'vue-router';
export interface RouteItem {
  path: string;
  component: any;
  meta: RouteMeta;
  name?: string;
  alias?: string | string[];
  redirect?: string;
  caseSensitive?: boolean;
  children?: RouteItem[];
}

export interface SetSensitiveItem {
  [propName:string]:string
}

export interface RouteResult {
  menuTree:RouteItem[];
  authList:string[];
  setSensitiveList:SetSensitiveItem[]
}

/**
 * @description: Get menu return value
 */
export type getMenuListResultModel = RouteResult;
