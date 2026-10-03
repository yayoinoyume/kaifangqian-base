/*
 * @description 资助审批电子签章系统
 */

/**
 * Global sensitive directive
 * Used for fine-grained control of component operation
 * @Example v-sensitive="[user:add,user:edit]"
 */
 import type { App, Directive, DirectiveBinding } from 'vue';

 import { usePermission } from '/@/hooks/web/usePermission';
 
 function isSensitive(el: Element, binding: any) {
  console.log(el,'点击了事件')
   const { isSensitive } = usePermission();
 
   const value = binding.value;
   if (!value) return;
   if (!isSensitive(value)) {
     el.parentNode?.removeChild(el);
   }
 }
 
 const mounted = (el: Element, binding: DirectiveBinding<any>) => {
   isSensitive(el, binding);
 };
 
 const sensitiveDirective: Directive = {
   mounted,
 };
 
 export function setupSensitiveDirective(app: App) {
   app.directive('sensitive', sensitiveDirective);
 }
 
 export default sensitiveDirective;
 