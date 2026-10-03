/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const system: AppRouteModule = {
  path: '/system',
  name: 'System',
  component: LAYOUT,
  redirect: '/System',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:setting-outlined',
    title: '系统管理',
    orderNo: 20,
  },
  children: [
    {
      path: 'menu',
      name: 'Menu',
      component: () => import( /* @vite-ignore */'/@/views/sys/menu/index.vue'),
      meta: {
        title: '菜单管理',
        hideMenu: false,
      },
    },
    {
      path: 'syslog',
      name: 'Syslog',
      component: () => import(/* @vite-ignore */ '/@/views/sys/logs/index.vue'),
      meta: {
        title: '系统日志',
      },
    },
    {
      path: 'safe',
      name: 'Safe',
      component: () => import(/* @vite-ignore */ '/@/views/sys/safe/index.vue'),
      meta: {
        title: '安全配置',
      },
    },
  ],
};

export default system;
