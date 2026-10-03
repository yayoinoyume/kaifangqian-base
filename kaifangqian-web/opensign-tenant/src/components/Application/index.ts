/*
 * @description 资助审批电子签章系统
 */

// import { withInstall } from '/@/utils';

import appLogo from './src/AppLogo.vue';
import appProvider from './src/AppProvider.vue';
import appSearch from './src/search/AppSearch.vue';
import appDarkModeToggle from './src/AppDarkModeToggle.vue';

import { withInstall } from '/@/utils';

export { useAppProviderContext } from './src/useAppContext';

export const AppLogo = appLogo?withInstall(appLogo):undefined;
export const AppProvider = withInstall(appProvider);
export const AppSearch = withInstall(appSearch);
export const AppDarkModeToggle = withInstall(appDarkModeToggle);
console.log(appLogo,'---eeeee-')
// export const AppLogo = appLogo;
// export const AppProvider = appProvider
// export const AppSearch = appSearch
// export const AppDarkModeToggle = appDarkModeToggle
