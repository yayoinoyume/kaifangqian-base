/**
 * @description : 全局状态
 */
// Lock screen information
export interface LockInfo {
  // Password required
  pwd?: string | undefined;
  // Is it locked?
  isLock?: boolean;
}
 
// export interface TenantInfo {
//   departId:string;
//   departName:string;
//   selectFlag:boolean;
//   tenantId:string | null;
// }
export interface TenantInfo {
  tenantId?: string ;
  tenantType?: string;
  id?:string;
  tenantName?: string;
  organizationNo?: string;
  corporation?: string;
  corporationNo?: string;
  phone?: string;
  email?: string;
  tenantProvince?: string;
  tenantCity?: string;
  tenantDistrict?:string;
  organizationAddress?:string;
  lifespanType?:string;
  contactsName?:string;
  contactsEmail?:string;
  contactsPhone?:string;
  authStatus?:string;
  idPic1:any,
  idPic2:any,
  organizationPic:any,
  [key: string]: string;
}

export interface TenantDepartList {
  tenantId:string;
  tenantName:string;
  selectFlag?:boolean;
  departs:TenantInfo[],
  useFlag?:boolean
  
}

export interface UserInfo {
  loginDepartId?: any;
  loginTenantId?: string | null;
  loginTenantType?: string | null;
  jobAppId?: string;
  id?:string;
  userId?: string | number;
  username?: string;
  realname?: string;
  avatar?: string;
  avatarImg?: string;
  desc?: string;
  homePath?: string;
  roles?: any;
  phone?:string;
  email?:string;
  departNames?:[];
  roleNames?:[];
  createTime?:[];
  passwordEditFlag?:boolean;
  initUserInfo?:boolean;
  passwordLevel?:string;
  tenantUserId?:string;
  loginTenantName?:string;
  loginDepartName?:string;
  personalTenantFlag?:boolean;
  nickName?:string;
  // [key: string]: string;
}

 

export interface SafeInfo {
  phone?: string | number;
  username: string | number;
}

export interface PerInfo {
  authList:[],
  menuTree:[]
}

export interface SensitiveHeaderState {
  sensitivePassword?:string;
  sensitiveTelepon?:string;
  sensitiveCaptch?:string;
  sensitiveCaptchKey?:string;
}
