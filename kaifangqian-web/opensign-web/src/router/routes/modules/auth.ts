/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const auth: AppRouteModule = {
  path: '/auth',
  name: 'auth',
  component: LAYOUT,
  redirect: '/auth',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:safety-outlined',
    title: '权限管理',
    orderNo: 20,
  },
  children: [
    {
      path: 'group',
      name: 'Group',
      component: () => import( /* @vite-ignore */'/@/views/auth/authGroup.vue'),
      meta: {
        title: '权限组管理',
        hideMenu: false,
      },
    },
    {
      path: 'ploy',
      name: 'Ploy',
      component: () => import(/* @vite-ignore */ '/@/views/auth/authPloy.vue'),
      meta: {
        title: '权限策略管理',
      },
    },
  ],
};

export default auth;
