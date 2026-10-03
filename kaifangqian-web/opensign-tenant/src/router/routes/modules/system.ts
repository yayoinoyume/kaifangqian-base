/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const system: AppRouteModule = {
  path: '/system',
  name: '组织管理',
  component: LAYOUT,
  redirect: '/System',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:setting-outlined',
    title: '组织管理',
    orderNo: 20,
  },
  children: [
    {
      path: 'organize',
      name: '组织管理',
      component: () => import( /* @vite-ignore */'/@/views/tenant/organize/index.vue'),
      meta: {
        title: '组织管理',
        hideMenu: false,
      },
    },
    
  ],
};

export default system;
