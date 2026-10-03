/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteModule } from '/@/router/types';
import { LAYOUT } from '/@/router/constant';

const message: AppRouteModule = {
  path: '/msg',
  name: 'Msg',
  component: LAYOUT,
  redirect: '/msg',
  meta: {
    hideChildrenInMenu: false,
    icon: 'ant-design:mail-outlined',
    title: '消息管理',
    orderNo: 24,
  },
  children: [
    {
      path: 'template',
      name: 'Template',
      component: () => import( /* @vite-ignore */'/@/views/message/Template.vue'),
      meta: {
        title: '消息模板',
        hideMenu: false,
      },
    },
    {
      path: 'myMessage',
      name: 'MyMessage',
      component: () => import(/* @vite-ignore */ '/@/views/message/MyMessage.vue'),
      meta: {
        title: '我的消息',
      },
    },
    {
      path: 'announcement',
      name: 'Announcement',
      component: () => import(/* @vite-ignore */ '/@/views/message/Announcement.vue'),
      meta: {
        title: '公告发布',
      },
    },
    {
      path: 'myAnnounce',
      name: 'MyAnnounce',
      component: () => import(/* @vite-ignore */ '/@/views/message/MyAnnounce.vue'),
      meta: {
        title: '我的公告',
      },
    },
  ],
};

export default message;
