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

const IFrame = () => import('/@/views/sys/iframe/index.vue');

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
export const PAGE_INSIDE_LINK: AppRouteRecordRaw = {
  path: '/sys/iframe',
  name: PAGE_INSIDE_NAME,
  component: LAYOUT,
  meta: {
    hideMenu: true,
    title: '内部链接',
  },
  children: [
    {
      path: '/sys/iframe',
      name: 'Doc',
      component: IFrame,
      meta: {
        hideMenu: true,
        title: '内部链接',
      },
    },
  ],
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

export const ERROR_LOG_ROUTE: AppRouteRecordRaw = {
  path: '/error-log',
  name: 'ErrorLog',
  component: LAYOUT,
  redirect: '/error-log/list',
  meta: {
    title: 'ErrorLog',
    hideBreadcrumb: true,
    hideChildrenInMenu: true,
  },
  children: [
    {
      path: 'list',
      name: 'ErrorLogList',
      component: () => import('/@/views/sys/error-log/index.vue'),
      meta: {
        title: '错误日志',
        hideBreadcrumb: true,
        currentActiveMenu: '/error-log',
      },
    },
  ],
};
