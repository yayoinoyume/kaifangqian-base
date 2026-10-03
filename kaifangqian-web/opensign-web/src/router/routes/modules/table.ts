/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';

import { LAYOUT } from '/@/router/constant';

const table: AppRouteModule = {
  path: '/table',
  name: 'Table',
  component: LAYOUT,
  redirect: '/table/normal',
  meta: {
    hideChildrenInMenu: false,
    icon: 'simple-icons:about-dot-me',
    title: '列表',
    orderNo: 12,
  },
  children: [
    {
      path: 'normal',
      name: 'RegularTable',
      component: () => import('/@/views/demo/table/RegularTable.vue'),
      meta: {
        title: '普通列表',
        icon: 'simple-icons:about-dot-me',
        orderNo: 121,
      },
    },
    {
      path: 'expand',
      name: 'ExpandTable',
      component: () => import('/@/views/demo/table/ExpandTable.vue'),
      meta: {
        title: '展开列表',
        icon: 'simple-icons:table-outlined',
        orderNo: 122,
      },
    },
    {
      path: 'edit',
      name: 'EditTable',
      component: () => import('/@/views/demo/table/EditTable.vue'),
      meta: {
        title: '编辑列表',
        icon: 'simple-icons:table-outlined',
        orderNo: 123,
      },
      
    }
  ],
};

export default table;
