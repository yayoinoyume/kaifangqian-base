/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';



export const getStatisticSeal = (params) => defHttp.get({ url: "/sign/statistics/seal" ,params});

export const getStatisticUseSeal = (params) => defHttp.get({ url: "/sign/statistics/useSeal" ,params});

