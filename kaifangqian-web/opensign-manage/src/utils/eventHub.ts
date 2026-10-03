/*
 * @description 资助审批电子签章系统
 */

import mitt from 'mitt'

const eventHub = mitt();

eventHub.$on = eventHub.on;
eventHub.$off = eventHub.off;
eventHub.$emit = eventHub.emit;

export default eventHub