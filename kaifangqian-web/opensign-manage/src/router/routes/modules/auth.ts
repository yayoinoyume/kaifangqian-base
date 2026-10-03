/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const auth: AppRouteModule = {
  path: '/auth',
  name: '权限',
  component: LAYOUT,
  redirect: '/group',
  meta: {
    hideMenu: true,
    hideChildrenInMenu:true,
    icon: 'ant-design:setting-outlined',
    title: '权限',
    orderNo: 20,
  },
  children: [
    {
      path: 'group',
      name: '权限管理',
      component: () => import( /* @vite-ignore */'/@/views/auth/authGroup.vue'),
      meta: {
        title: '权限管理',
        hideMenu: false,
      },
    },
    {
      path: 'ploy',
      name: '数据权限策略管理',
      component: () => import( /* @vite-ignore */'/@/views/auth/authPloy.vue'),
      meta: {
        title: '数据权限策略管理',
        hideMenu: false,
      },
    }
    
  ],
};


export default auth;
