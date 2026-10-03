/*
 * @description 资助审批电子签章系统
 */


 
// if (window.__POWERED_BY_QIANKUN__) {
//    __webpack_public_path__ = window.__INJECTED_PUBLIC_PATH_BY_QIANKUN__;
// }

// __MICRO_APP_ENVIRONMENT__和__MICRO_APP_PUBLIC_PATH__是由micro-app注入的全局变量

export default function MicroEnv(){
  console.log('微应用判断')
  if (window.__MICRO_APP_ENVIRONMENT__) {
    console.log('开发签-----------我在微前端环境中')
    // eslint-disable-next-line
    __webpack_public_path__ = window.__MICRO_APP_PUBLIC_PATH__
  }
}
