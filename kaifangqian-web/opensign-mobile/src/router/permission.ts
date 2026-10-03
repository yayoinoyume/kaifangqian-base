/**
 * @description : 路由守卫
 */

import type { Router, RouteRecordRaw } from 'vue-router';
import { Notify } from 'vant';
import { APP_TOKEN, CACHE_VIEWS } from '@/utils/cache/constant';
import session from '@/utils/cache/session';
import { useUserStore } from '@/store/modules/user';
import { useMenuStore } from '@/store/modules/menu';

const whitePathList: any = ['/base', '/check/face'];
export function setupRouterGuard(router: Router) {
  router.beforeEach(async (to, from, next) => {
    const userStore = useUserStore();
    await userStore.buildWebConfig();
    const token = userStore.getAppToken;
    if (to.path == '/login') {
      console.log('login token:', token);
      // 登录或者注册才可以往下进行
      if (token) {
        next('/index');
      } else {
        next();
      }
      // next();
    } else {
      if (userStore.getLastUpdateTime === 0) {
        await userStore.reloadTenantInfo();
        await userStore.afterLoginAction();
      }
      const menuInfo = useMenuStore();
      if (
        (to.path == '/personal' && from.path == '/signContract') ||
        (from.path == '/personal' && to.path == '/signContract')
      ) {
        menuInfo.setCacheViews(CACHE_VIEWS);
      } else {
        const cacheViews = menuInfo.getCacheViews;
        const nowCaches = cacheViews.filter((v) => v !== 'signContract');
        menuInfo.setCacheViews(nowCaches);
      }
      // 获取 token
      // const token = session.getItem(APP_TOKEN);
      // token 不存在
      if (whitePathList.includes(to.path)) {
        next();
        return;
      }
      if (token === null || token === '') {
        // Notify({ type: 'warning', message: '暂无登录信息', duration: 1000 });
        next('/login');
      } else {
        next();
      }
    }
  });
}
