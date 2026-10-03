/*
 * @description 资助审批电子签章系统
 */

import { nextTick, onMounted, onActivated } from 'vue';

export function onMountedOrActivated(hook: Fn) {
  let mounted: boolean;

  onMounted(() => {
    hook();
    nextTick(() => {
      mounted = true;
    });
  });

  onActivated(() => {
    if (mounted) {
      hook();
    }
  });
}
