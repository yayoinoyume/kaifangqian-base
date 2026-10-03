/*
 * @description 资助审批电子签章系统
 */

import { YdCallBackPage } from "../router/routes";

export enum PageEnum {
  // basic login path
  BASE_LOGIN = '/login',
  // basic auth login path
  AUTH_LOGIN = '/auth/login',
  // app default page 
  DEFAULT_HOME = '/dashboard',
  // basic home path
  BASE_HOME = '/dashboard/workbench',
  // error page path
  ERROR_PAGE = '/exception',
  // error log page path
  ERROR_LOG_PAGE = '/error-log/list',
  // join orgnize
  JOIN_PATH = '/join',
  // join orgnize
  CONTRACT_BASE_PATH = '/contract/detail/base',
  // register
  REGISTER_PATH = '/register',
  // terms
  TERM_SERVICE = '/terms/service',
  // policy
  PRICACY_POLICY = '/privacy/policy',
 // transition
  TRANSITION_PATH = '/transition',
  WISHCHECK = '/wishCheck',
  YD_CALLBACKPAGE = '/callbackpage',

  CONTRACT_SIGN = '/contract/sign'
}
