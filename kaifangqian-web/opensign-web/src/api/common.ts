/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export function getSignConfirm() {
  return defHttp.get(
    { url: '/sign/confirm/type' },
    { errorMessageMode: 'none', isTransformResponse: false },
  );
}
