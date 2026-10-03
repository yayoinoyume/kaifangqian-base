/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export enum Api {
  sign_generate = "/sign/person/seal/generate/param",
  sign_save = "/sign/person/seal/save",
  sign_list = "/sign/person/seal/list",
  sign_default = "/sign/person/seal/isDefault",
  sign_delete = "/sign/person/seal/delete",
  sign_base64 = "/sign/person/seal/generate/upload",
}



export const signGenerate = (params) => defHttp.post({ url: Api.sign_generate ,params});
export const signBase64 = (params) => defHttp.post({ url: Api.sign_base64 ,params});
export const signSave = (params) => defHttp.post({ url: Api.sign_save ,params},{isTransformResponse:false});

export const signList = (params) => defHttp.get({ url: Api.sign_list ,params});
export const signDefault = (params) => defHttp.put({ url: Api.sign_default ,params},{isTransformResponse:false});
export const signDelete = (params) => defHttp.delete({ url: Api.sign_delete ,params},{isTransformResponse:false});





