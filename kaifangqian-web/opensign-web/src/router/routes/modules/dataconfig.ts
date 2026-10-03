/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const dataConfig: AppRouteModule = {
  path: '/data',
  name: 'Data',
  component: LAYOUT,
  redirect: '/data',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:database-outlined',
    title: '数据配置',
    orderNo: 26,
  },
  children: [
    {
      path: 'dict',
      name: 'Dict',
      component: () => import( /* @vite-ignore */'/@/views/dataconfig/Dict.vue'),
      meta: {
        title: '数据字典',
        hideMenu: false,
      },
    },
    {
      path: 'serial',
      name: 'SerialNumber',
      component: () => import( /* @vite-ignore */'../../../views/dataconfig/SerialNumber.vue'),
      meta: {
        title: '编号规则',
        hideMenu: false,
      },
    },
    {
      path: 'verify',
      name: 'Verify',
      component: () => import( /* @vite-ignore */'/@/views/dataconfig/Verify.vue'),
      meta: {
        title: '系统校验规则',
        hideMenu: false,
      },
    },
  ],
};

export default dataConfig;
