/*
 * @description 资助审批电子签章系统
 */


import appLogo from './src/AppLogo.vue';
import appProvider from './src/AppProvider.vue';
import appDarkModeToggle from './src/AppDarkModeToggle.vue';

import { withInstall } from '/@/utils';

export { useAppProviderContext } from './src/useAppContext';

export const AppLogo = appLogo?withInstall(appLogo):undefined;
export const AppProvider = withInstall(appProvider);
export const AppDarkModeToggle = withInstall(appDarkModeToggle);
