/*
 * @description 资助审批电子签章系统
 */

import type { AppRouteRecordRaw, AppRouteModule } from '/@/router/types';

import { PAGE_NOT_FOUND_ROUTE, REDIRECT_ROUTE } from '/@/router/routes/basic';

import { PageEnum } from '/@/enums/pageEnum';

import { LAYOUT } from '/@/router/constant';


// const modules = import.meta.globEager('./modules/**/*.ts');
const modules = import.meta.globEager('./modules/*.ts');


const routeModuleList: AppRouteModule[] = [];

Object.keys(modules).forEach((key) => {
  const mod = modules[key].default || {};
  const modList = Array.isArray(mod) ? [...mod] : [mod];
  routeModuleList.push(...modList);
});

export const asyncRoutes = [PAGE_NOT_FOUND_ROUTE, ...routeModuleList];

export const RootRoute: AppRouteRecordRaw = {
  path: '/',
  name: 'Root',
  redirect: PageEnum.BASE_HOME,
  meta: {
    title: 'Root',
  },
};

export const LoginRoute: AppRouteRecordRaw = {
  path: '/login',
  name: 'Login',
  component: () => import('/@/views/sys/login/Login.vue'),
  meta: {
    title: '登录',
  },
};
export const JoinRoute: AppRouteRecordRaw = {
  path: '/join',
  name: 'Join',
  component: () => import('/@/views/sys/login/Join.vue'),
  meta: {
    title: '加入',
  },
}
export const ExperienceLoginRoute: AppRouteRecordRaw = {
  path: '/login/experience',
  name: 'Login',
  component: () => import('/@/views/sys/login/Login.vue'),
  meta: {
    title: '体验登录',
  },
};

export const ApplicationInsideRoute: AppRouteRecordRaw = {
  path: '/tenant/appmanage',
  name: '应用管理',
  parentId:'',
  menuType:0,
  icon: 'ant-design:appstore-outlined',
  component: LAYOUT,
  redirect: '/tenant/appmanage/basic',
  meta: {
    hideMenu:false,
    title: '应用管理',
  },
  children:[]
}
export const MicroForm : AppRouteModule = {
  path:'/micro/form',
  name:'MicroForm',
  component: () => import('/@/views/microform/index.vue'),
  meta: {
    title: '表单',
  },
}
// Basic routing without permission
// export const basicRoutes = [ExperienceLoginRoute, LoginRoute, RootRoute, REDIRECT_ROUTE, PAGE_NOT_FOUND_ROUTE, JoinRoute];
export const basicRoutes = [ExperienceLoginRoute, RootRoute, REDIRECT_ROUTE, PAGE_NOT_FOUND_ROUTE, JoinRoute, MicroForm];
