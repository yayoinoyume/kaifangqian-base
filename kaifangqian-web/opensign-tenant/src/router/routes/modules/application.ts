/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const application: AppRouteModule = {
  path: '/application',
  name: '应用管理',
  component: LAYOUT,
  redirect: '/Application',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:setting-outlined',
    title: '应用管理',
    orderNo: 20,
  },
  children: [
    {
      path: 'app',
      name: '应用管理',
      component: () => import( /* @vite-ignore */'/@/views/tenant/application/index.vue'),
      meta: {
        title: '应用管理',
        hideMenu: false,
      },
    },
    
  ],
};

export default application;
