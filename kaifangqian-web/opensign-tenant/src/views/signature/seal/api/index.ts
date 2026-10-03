/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';
import qs from "qs";
export enum Api {
  DOC_LIST = '/m1/3157580-0-default/mock/seal/doc/list',
  make_seal = "/sign/ent/seal/save",
  edit_seal = "/sign/ent/seal/edit",
  generate_seal = "/sign/ent/seal/generate/param",
  template_generate_seal = "/sign/ent/seal/generate/upload",
  seak_list = "/sign/ent/seal/list",
  seal_detailes = "/sign/ent/seal/info",
  seal_apply_detailes = "/sign/ent/seal/info/apply",
  seal_change = "/sign/ent/seal/change",
  
  seal_stop = "/sign/ent/seal/unenabled",
  seal_start = "/sign/ent/seal/enabled",
  //销毁
  seal_destruction = "/sign/ent/seal/destruction",
  //收缴
  seal_divested = "/sign/ent/seal/divested",
  
  seal_delete_log = "/sign/ent/seal/log/delete",
}



export const makeSeal = (params) => defHttp.post({ url: Api.make_seal ,params},{isTransformResponse:false});
export const editSeal = (params) => defHttp.put({ url: Api.edit_seal ,params},{isTransformResponse:false});
export const sealChange = (params) => defHttp.put({ url: Api.seal_change ,params},{isTransformResponse:false});


export const generateSeal = (params) => defHttp.post({ url: Api.generate_seal ,params});

export const templateGenerateSeal = (params) => defHttp.post({ url: Api.template_generate_seal ,params});

export const sealList = (params)=>defHttp.get({ url: Api.seak_list ,params});
export const enabledList = (params)=>defHttp.get({ url:"/sign/ent/seal/enabledList" ,params});

export const sealAuthList = (params)=>defHttp.get({ url: '/sign/ent/seal/auth/list' ,params});

export const getSealDetailes = (params)=>defHttp.get({ url: Api.seal_detailes ,params});

export const getSealApplyDetailes = (params)=>defHttp.get({ url: Api.seal_apply_detailes ,params});


export const sealRecordList = (params)=>defHttp.get({
  url: "/sign/ent/seal/log/list",
  params:params,
  paramsSerializer:function(params){
    return qs.stringify(params, { arrayFormat: "repeat" });  
  }
});

export const getSealApplyId = (api:Api,params)=>defHttp.put({ url: api ,params});

export const setSealReason = (params)=>defHttp.put({ url: "/sign/ent/seal/reason" ,params});
export const deleteSealLog = (params)=>defHttp.delete({ url: "/sign/ent/seal/log/delete" ,params});
