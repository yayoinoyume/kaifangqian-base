/*
 * @description 资助审批电子签章系统
 */

import type { App } from 'vue';
// import {Button,SensitiveButton } from './Button';
import {BasicToolTip} from './ToolTip';
import  Antd  from 'ant-design-vue';
import  {Card}  from 'ant-design-vue';


export function registerGlobComp(app: App) {
  // app.use(Input).use(Button).use(Layout);
  app.use(Card)
  app.use(BasicToolTip);
  app.use(Antd);
}
