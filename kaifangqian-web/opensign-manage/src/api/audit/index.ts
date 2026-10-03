/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  EnterpriseAuditList = '/system/tenantInfoExtend/enterprise/auth/audit/list',
  EnterpriseAuditCheck= '/system/tenantInfoExtend/enterprise/auth/audit',
  EnterpriseAuditInfo = '/system/tenantInfoExtend/enterprise/auth/log',

}

/**
 * @description: 企业认证记录审核列表
 */
export function getEnterpriseAuditList(params) {
  return defHttp.get({ url: Api.EnterpriseAuditList,params });
}

/**
 * @description: 企业认证记录审核
 */
export function checkEnterpriseAudit(params) {
  return defHttp.post({ url: Api.EnterpriseAuditCheck,params });
}
/**
 * @description: 企业认证记录详情
 */
export function getEnterpriseAuditInfo(params) {
  return defHttp.get({ url: Api.EnterpriseAuditInfo + '/' + params.id,params });
}