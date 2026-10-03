/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteRecordRaw } from '/@/router/types';
import {
  REDIRECT_NAME,
  LAYOUT,
  EXCEPTION_COMPONENT,
  PAGE_NOT_FOUND_NAME,
  PAGE_INSIDE_NAME,
} from '/@/router/constant';


export const PAGE_NOT_FOUND_ROUTE: AppRouteRecordRaw = {
  path: '/:path(.*)*',
  name: PAGE_NOT_FOUND_NAME,
  component: LAYOUT,
  meta: {
    title: 'ErrorPage',
    hideBreadcrumb: true,
    hideMenu: true,
  },
  // children: [
  //   {
  //     path: '/:path(.*)*',
  //     name: PAGE_NOT_FOUND_NAME,
  //     component: EXCEPTION_COMPONENT,
  //     meta: {
  //       title: 'ErrorPage',
  //       hideBreadcrumb: true,
  //       hideMenu: true,
  //     },
  //   },
  // ],
};

export const REDIRECT_ROUTE: AppRouteRecordRaw = {
  path: '/redirect',
  component: LAYOUT,
  name: 'RedirectTo',
  meta: {
    title: REDIRECT_NAME,
    hideBreadcrumb: true,
    hideMenu: true,
  },
  children: [
    {
      path: '/redirect/:path(.*)',
      name: REDIRECT_NAME,
      component: () => import('/@/views/sys/redirect/index.vue'),
      meta: {
        title: REDIRECT_NAME,
        hideBreadcrumb: true,
      },
    },
  ],
};

