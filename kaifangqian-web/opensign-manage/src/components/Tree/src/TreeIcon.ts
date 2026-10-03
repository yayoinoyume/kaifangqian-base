/*
 * @description 资助审批电子签章系统
 */

import type { VNode, FunctionalComponent } from 'vue';

import { h } from 'vue';
import { isString } from '@vue/shared';
import { Icon } from '/@/components/Icon';

export const TreeIcon: FunctionalComponent = ({ icon, color }: { icon: VNode | string, color: string }) => {
  if (!icon) return null;
  if (isString(icon)) {
    return h(Icon, { icon, class: 'mr-1', color });
  }
  return Icon;
};
