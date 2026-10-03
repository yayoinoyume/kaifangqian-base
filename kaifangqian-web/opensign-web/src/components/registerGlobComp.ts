/*
 * @description 资助审批电子签章系统
 */

import type { App } from 'vue';
// import {Button,SensitiveButton } from './Button';
// import { Input, Layout } from 'ant-design-vue';
import {BasicToolTip} from './ToolTip';
import  Antd  from 'ant-design-vue';


export function registerGlobComp(app: App) {
  // app.use(Input).use(Button).use(Layout);
  app.use(BasicToolTip);
  app.use(Antd);
}
