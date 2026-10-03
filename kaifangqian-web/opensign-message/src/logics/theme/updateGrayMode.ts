/*
 * @description 资助审批电子签章系统
 */

import { toggleClass } from './util';

/**
 * Change project gray mode status
 * @param gray
 */
export function updateGrayMode(gray: boolean) {
  toggleClass(gray, 'gray-mode', document.documentElement);
}
