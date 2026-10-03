/**
 * @description : 路由配置文件
 */
import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router';

export const layoutRoutes: Array<RouteRecordRaw> = [
  {
    path: 'index',
    name: '资助审批电子签章系统',
    meta: {
      title: '资助审批电子签章系统',
      leftArrow: false,
      keepAlive: true,
    },
    component: () => import('@/pages/index.vue'),
  },
  {
    path: '/write/:signRuId?/:taskId?',
    name: '填写',
    meta: {
      title: '资助审批电子签章系统',
      leftArrow: true,
      keepAlive: false,
    },
    component: () => import('@/pages/signwrite/write.vue'),
  },
  {
    path: '/detail/:signRuId?',
    name: '详情',
    meta: {
      title: '资助审批电子签章系统',
      leftArrow: true,
      keepAlive: false,
    },
    component: () => import('@/pages/detail/docDetail.vue'),
  },
  {
    path: '/doc/:signRuId?/:docId?',
    name: '签约文档',
    meta: {
      title: '资助审批电子签章系统',
      leftArrow: true,
      keepAlive: false,
    },
    component: () => import('@/pages/components/Document.vue'),
  },

  {
    path: 'image-rotate',
    name: 'image-rotate',
    meta: {
      title: 'image-rotate',
    },
    component: () => import('@/pages/image-rotate/index.vue'),
  },
  {
    path: '/signContract/:signRuId?',
    name: '签署',
    meta: {
      title: '签署',
      leftArrow: true,
      keepAlive: true,
    },
    component: () => import('@/pages/contract/SignContract.vue'),
  },
  {
    path: '/approval/:signRuId?',
    name: '审批',
    meta: {
      title: '审批',
      leftArrow: true,
      keepAlive: true,
    },
    component: () => import('@/pages/contract/approval.vue'),
  },
  {
    path: '/wishCheck',
    name: '签署结果',
    meta: {
      title: '签署结果',
      leftArrow: true,
      keepAlive: true,
    },
    component: () => import('@/pages/contract/WishCheck.vue'),
  },
  {
    path: '/noauth',
    name: '无权访问',
    meta: {
      title: '无权访问',
      leftArrow: false,
      keepAlive: false,
    },
    component: () => import('@/pages/base/noAuth.vue'),
  },
  {
    path: '/enterprise',
    name: '企业实名',
    meta: {
      title: '企业实名',
      leftArrow: true,
      keepAlive: false,
    },
    component: () => import('@/pages/auth/enterprise.vue'),
  },
  {
    path: '/enterprise/details',
    name: '企业实名详情',
    meta: {
      title: '实名详情',
      leftArrow: true,
      keepAlive: false,
    },
    component: () => import('@/pages/auth/enterpriseDetails.vue'),
  },

  {
    path: '/personal/:authStatus?',
    name: '个人实名',
    meta: {
      title: '个人实名',
      leftArrow: true,
    },
    component: () => import('@/pages/auth/personal.vue'),
  },
  {
    path: '/personal/details',
    name: '个人实名详情',
    meta: {
      title: '个人实名详情',
      leftArrow: true,
    },
    component: () => import('@/pages/auth/personalDetails.vue'),
  },
];

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: () => import('@/layout/index.vue'),
    redirect: '/index',
    children: layoutRoutes,
  },
  // 不需要layout的页面
  {
    path: '/login',
    name: 'login',
    meta: {
      title: 'login',
    },
    component: () => import('@/pages/login/index.vue'),
  },
  {
    path: '/base/:code?',
    name: 'base',
    meta: {
      title: 'base',
    },
    component: () => import('@/pages/base/index.vue'),
  },
  {
    path: '/check/face',
    name: 'checkFace',
    meta: {
      title: 'check',
    },
    component: () => import('@/pages/base/FaceLoading.vue'),
  },
  // 替代vue2中的'*'通配符路径
  { path: '/:pathMatch(.*)*', redirect: '/' },
];

const router = createRouter({
  history: createWebHashHistory(), // history 模式则使用 createWebHistory()
  routes,
});
export default router;
