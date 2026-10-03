/*
 * @description 资助审批电子签章系统
 */

import { withInstall } from '/@/utils';
import countButton from './src/CountButton.vue';
import countdownInput from './src/CountdownInput.vue';

export const CountdownInput = withInstall(countdownInput);
export const CountButton = withInstall(countButton);
