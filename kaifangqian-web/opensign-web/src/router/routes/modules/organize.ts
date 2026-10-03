/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const organize: AppRouteModule = {
  path: '/organize',
  name: 'Organize',
  component: LAYOUT,
  redirect: '/organize',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:appstore-outlined',
    title: '组织管理',
    orderNo: 20,
  },
  children: [
    {
      path: 'index',
      name: 'Organize',
      component: () => import( /* @vite-ignore */'/@/views/organize/index.vue'),
      meta: {
        title: '组织管理',
        hideMenu: false,
      },
    },
    {
      path: 'editTree',
      name: 'EditTreeDemo',
      component: () => import(/* @vite-ignore */ '/@/views/demo/tree/EditTree.vue'),
      meta: {
        title: '搜索tree',
      },
    },
  ],
};

export default organize;
