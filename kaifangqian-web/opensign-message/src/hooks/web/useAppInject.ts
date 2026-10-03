/*
 * @description 资助审批电子签章系统
 */

import { useAppProviderContext } from '/@/components/Application';
import { computed, unref } from 'vue';

export function useAppInject() {
  const values = useAppProviderContext();

  return {
    getIsMobile: computed(() => unref(values.isMobile)),
  };
}
