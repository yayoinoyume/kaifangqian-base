/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
 AuthTestData = '/test/testDataAuthF/list',
}



/**
 * @description: getAuthGroup
 */
export function getTestAuthDataList(params) {
  return defHttp.get({ url: Api.AuthTestData,params }, { errorMessageMode: 'none' });
}
