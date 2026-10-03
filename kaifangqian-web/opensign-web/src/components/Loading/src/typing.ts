/*
 * @description 资助审批电子签章系统
 */

import { SizeEnum } from '/@/enums/sizeEnum';

export interface LoadingProps {
  tip: string;
  size: SizeEnum;
  absolute: boolean;
  loading: boolean;
  background: string;
  theme: 'dark' | 'light';
}
