/*
 * @description 资助审批电子签章系统
 */

import type { Router, RouteRecordRaw } from 'vue-router';

import { usePermissionStoreWithOut } from '/@/store/modules/permission';

import { PageEnum } from '/@/enums/pageEnum';
import { useUserStoreWithOut } from '/@/store/modules/user';

import { PAGE_NOT_FOUND_ROUTE } from '/@/router/routes/basic';

import { getHashQueryString } from '/@/utils';

import { RootRoute } from '/@/router/routes';

const LOGIN_PATH = PageEnum.BASE_LOGIN;

const AUTH_LOGIN = PageEnum.AUTH_LOGIN;

const JOIN_PATH = PageEnum.JOIN_PATH;

const REGISTER_PATH = PageEnum.REGISTER_PATH;

const TERM_SERVICE = PageEnum.TERM_SERVICE;

const PRICACY_POLICY = PageEnum.PRICACY_POLICY;

const ROOT_PATH = RootRoute.path;

const whitePathList: PageEnum[] = [LOGIN_PATH, AUTH_LOGIN, JOIN_PATH,REGISTER_PATH,TERM_SERVICE,PRICACY_POLICY];


const userStore = useUserStoreWithOut();
const appToken = getHashQueryString('token');
const loginToken = getHashQueryString('loginToken');
const appId = getHashQueryString('appId');

//工作台单独存下应用token
if(appToken){
  userStore.setToken(appToken);
}
if(loginToken){
  userStore.setLoginToken(loginToken);
}

const shareToken =  getHashQueryString('token');
if(shareToken){
  userStore.setToken(shareToken)
}

export function createPermissionGuard(router: Router) {
  const permissionStore = usePermissionStoreWithOut();

  console.log('路由拦截开始', (userStore.getToken))

  if (window.eventCenterForAppNameVite) {
    // 主动获取基座下发的数据
    let defaultData = window.eventCenterForAppNameVite.getData();
    if(defaultData && !(userStore.getToken)){
      userStore.setToken(defaultData.token);
    }
    console.log(userStore.getToken, '获取的新token')
  }
  router.beforeEach(async (to, from, next) => {
    if (
      from.path === ROOT_PATH &&
      to.path === PageEnum.BASE_HOME &&
      userStore.getUserInfo.homePath &&
      userStore.getUserInfo.homePath !== PageEnum.BASE_HOME
    ) {
      next(userStore.getUserInfo.homePath);
      return;
    }

    // if (to.meta.title !== undefined && to.meta.title === from.meta.title) {
    //   next(`/redirect${to.path}`);
    // } else {
    //   next();
    // }
  

    const token = userStore.getToken;


    // Whitelist can be directly entered
    console.log(whitePathList.includes(to.path as PageEnum),to.path,whitePathList,'白名单')
    if (whitePathList.includes(to.path as PageEnum)) {
      if (to.path === LOGIN_PATH && token) {
        const isSessionTimeout = userStore.getSessionTimeout;
        try {
          await userStore.afterLoginAction();
          if (!isSessionTimeout) {
            next((to.query?.redirect as string) || '/');
            return;
          }
        } catch {}
      }
      next();
      return;
    }

    // token does not exist
    if (!token && !window.eventCenterForAppNameVite) {
      // You can access without permission. You need to set the routing meta.ignoreAuth to true
      if (to.meta.ignoreAuth) {
        next();
        return;
      }

      // redirect login page
      const redirectData: { path: string; replace: boolean; query?: Recordable<string> } = {
        path: LOGIN_PATH,
        replace: true,
      };
      if (to.path) {
        redirectData.query = {
          ...redirectData.query,
          // redirect: to.path,  
        };
      }
      next(redirectData);
      return;
    }

    // Jump to the 404 page after processing the login
    if (
      from.path === LOGIN_PATH &&
      to.name === PAGE_NOT_FOUND_ROUTE.name &&
      to.fullPath !== (userStore.getUserInfo.homePath || PageEnum.BASE_HOME)
    ) {
      next(userStore.getUserInfo.homePath || PageEnum.BASE_HOME);
      return;
    }
    // get userinfo while last fetch time is empty
    if (userStore.getLastUpdateTime === 0) {
      try {
        console.log('请求用户信息----')
        await userStore.getUserInfoAction();
        // await userStore.getTnantInfo();
      } catch (err) {
        next();
        return;
      }
    }

    if (permissionStore.getIsDynamicAddedRoute) {
      next();
      return;
    }

    const routes = await permissionStore.buildRoutesAction();
    console.log('请求接口路由---')

    routes.forEach((route) => {
      router.addRoute(route as unknown as RouteRecordRaw);
    });

    router.addRoute(PAGE_NOT_FOUND_ROUTE as unknown as RouteRecordRaw);

    permissionStore.setDynamicAddedRoute(true);

    if (to.name === PAGE_NOT_FOUND_ROUTE.name) {
      // 动态添加路由后，此处应当重定向到fullPath，否则会加载404页面内容
      if (window.eventCenterForAppNameVite) {
        next({ path: to.fullPath, replace: true, query: to.query });
      }else{
        next({ path: to.fullPath, replace: true, query: to.query });
      }

    } else {
      const redirectPath = (from.query.redirect || to.path) as string;
      const redirect = decodeURIComponent(redirectPath);
      const nextData = to.path === redirect ? { ...to, replace: true } : { path: redirect };
      next(nextData);
    }
  });
}
