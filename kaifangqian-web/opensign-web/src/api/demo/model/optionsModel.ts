/*
 * @description 资助审批电子签章系统
 */

import { BasicFetchResult } from '/@/api/model/baseModel';

export interface DemoOptionsItem {
  label: string;
  value: string;
}

export interface selectParams {
  id: number | string;
}

/**
 * @description: Request list return value
 */
export type DemoOptionsGetResultModel = BasicFetchResult<DemoOptionsItem>;
