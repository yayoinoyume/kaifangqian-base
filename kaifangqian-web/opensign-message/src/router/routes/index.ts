/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteRecordRaw } from '/@/router/types';
import {
   
    LAYOUT,
   
  } from '/@/router/constant';

import { PageEnum } from '/@/enums/pageEnum';


export const RootRoute: AppRouteRecordRaw = {
  path: '/',
  name: 'Root',
  redirect: PageEnum.BASE_HOME,
  meta: {
    title: 'Root',
  },
  component: LAYOUT,
  children:[
    {
        path: '/message',
        name: 'Message',
        meta: {
            title: '消息中心',
        },
        component: () => import('/@/views/message/index.vue'),
    }
  ]
};
export const basicRoutes = [RootRoute];
