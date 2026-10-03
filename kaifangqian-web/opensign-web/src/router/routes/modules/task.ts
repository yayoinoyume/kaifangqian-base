/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const task: AppRouteModule = {
  path: '/taskScheduling',
  name: 'taskScheduling',
  component: LAYOUT,
  redirect: '/taskScheduling',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:hourglass-outlined',
    title: '任务调度',
    orderNo: 25,
  },
  children: [
    {
      path: 'taskScheduling',
      name: 'TaskScheduling',
      component: () => import( /* @vite-ignore */'/@/views/task/TaskScheduling.vue'),
      meta: {
        title: '任务调度',
        hideMenu: false,
      },
    },
  ],
};

export default task;
