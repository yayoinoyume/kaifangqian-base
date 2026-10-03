/*
 * @description 资助审批电子签章系统
 */

//

import { defHttp } from '/@/utils/http/axios';


export const getSealAuditList = (params) => defHttp.get({ url: "/sign/statistics/useSealAudit" ,params});

