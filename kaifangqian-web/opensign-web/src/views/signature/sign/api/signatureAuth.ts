/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';


export function getMyConfirmType(params){
 return defHttp.get({ url: "/user/seal/auth/getMyConfirmType" ,params});
}


export function getListSignRe(params){
 return defHttp.get({ url: "/user/seal/auth/listSignRe" ,params});
}

export function getSealAuthList(params){
 return defHttp.get({ url: "/user/seal/auth/list" ,params});
}


export function saveSealAuth(params){
 return defHttp.post({ url: "/user/seal/auth/add" ,params});
}

export function cancleSealAuth(params){
 return defHttp.post({ url: "/user/seal/auth/cancle" ,params});
}

export function deleteSealAuth(params){
 return defHttp.delete({ url: "/user/seal/auth/delete" ,params});
}


