/*
 * @description 资助审批电子签章系统
 */

import { Router } from 'vue-router'
import { useUserStoreWithOut } from '/@/store/modules/user';


declare global {
  interface Window {
    eventCenterForTenantVite: any
    __MICRO_APP_NAME__: string
    __MICRO_APP_ENVIRONMENT__: string
    __MICRO_APP_BASE_APPLICATION__: string
  }
}

// 与基座进行数据交互
export function initMicroData (router: Router) {
  const userStore = useUserStoreWithOut();
  // eventCenterForTenantVite 是基座添加到window的数据通信对象
  if (window.eventCenterForTenantVite) {
    // 主动获取基座下发的数据
    console.log('child-vite getData:', window.eventCenterForTenantVite.getData())
    let token = window.eventCenterForTenantVite.getData()?.token;
    let defaultPath = window.eventCenterForTenantVite.getData()?.path;
    if(token){
      userStore.setToken(token);
    }
    console.log(defaultPath,'默认路径')
    if(defaultPath){
      router.push(defaultPath)
    }
    // 监听基座下发的数据变化
    window.eventCenterForTenantVite.addDataListener((data: Record<string, unknown>) => {
      console.log('child-vite addDataListener:', data)

      if (data.path && typeof data.path === 'string' && router) {
        data.path = data.path.replace(/^#/, '')
        // 当基座下发path时进行跳转
        if (data.path && data.path !== router.currentRoute.value.path) {
          router.push(data.path as string)
        }
      }
    })

    // 向基座发送数据
    setTimeout(() => {
      window.eventCenterForTenantVite.dispatch({ myname: 'child-vite' })
    }, 3000)
  }
}