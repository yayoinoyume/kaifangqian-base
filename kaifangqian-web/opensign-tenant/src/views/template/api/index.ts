/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export enum Api {
  save_template = "/sign/template/save",
  template_list = "/sign/template/list",
  template_info = "/sign/template/info",
  template_save_control = "/sign/template/save/control",
  template_submit = "/sign/template/submit",
  template_edit = "/sign/template/edit",
  template_delete = "/sign/template/delete",
  template_update_status = "sign/template/status",
  
  save_folder = "/sign/template/folder/save",
  get_folder_list = "/sign/template/folder/tree",
  
  template_folder_move = "/sign/template/folder/move",
  template_folder_join = "/sign/template/folder/join",
  template_folder_del = "/sign/template/folder/delete",
  download_param = "/sign/template/download/control"
  
}



export const saveTemplate = (params) => defHttp.post({ url: Api.save_template ,params},{isTransformResponse:false});
export const templateEdit = (params) => defHttp.post({ url: Api.template_edit ,params},{isTransformResponse:false});
export const templateChange = (params) => defHttp.post({ url: "/sign/template/change",params},{isTransformResponse:false});

export const getTemplateList= (params) => defHttp.get({ url: Api.template_list ,params});

export const getTemplateInfo= (params) => defHttp.get({ url: Api.template_info ,params});

export const getTemplateApplyInfo= (params) => defHttp.get({ url: "/sign/template/info/apply" ,params});


export const templateSaveControl = (params) => defHttp.post({ url: Api.template_save_control ,params},{isTransformResponse:false});

export const templateSubmit = (params) => defHttp.post({ url: Api.template_submit ,params},{isTransformResponse:false});

export const saveFolder = (params) => defHttp.post({ url: Api.save_folder ,params},{isTransformResponse:false});

export const getFolderList = (params) => defHttp.get({ url: Api.get_folder_list ,params});

export const templateFolderMove =(params)=>defHttp.post({ url: Api.template_folder_move ,params},{isTransformResponse:false});

export const templateFolderJoin =(params)=>defHttp.post({ url: Api.template_folder_join ,params},{isTransformResponse:false});
export const updateTemplateStatus =(params)=>defHttp.post({ url: Api.template_update_status ,params});



export const folderDelete =(params)=>defHttp.delete({ url: Api.template_folder_del ,params},{isTransformResponse:false});


export const templateDelete =(params)=>defHttp.delete({ url: Api.template_delete ,params});


export const downloadParam =(params)=>defHttp.post({ url: Api.download_param ,params});

// export const signSave = (params) => defHttp.post({ url: Api.sign_save ,params},{isTransformResponse:false});

// export const signList = (params) => defHttp.get({ url: Api.sign_list ,params});
// export const signDefault = (params) => defHttp.put({ url: Api.sign_default ,params},{isTransformResponse:false});
// export const signDelete = (params) => defHttp.delete({ url: Api.sign_delete ,params},{isTransformResponse:false});


export const unenabled =(params)=>defHttp.post({ url: "/sign/template/unenabled" ,params});

export const enabled =(params)=>defHttp.post({ url: "/sign/template/enabled" ,params});


export const operateList= (params) => defHttp.get({ url: "/sign/template/operateLog/list" ,params});
export const applyList= (params) => defHttp.get({ url: "/sign/template/applyLog/list" ,params});


export const deleteApproveRecord =(params)=>defHttp.get({ url: "/sign/template/applyLog/delete" ,params});


export const templateVerifyControl =(params)=>defHttp.get({ url: "/sign/template/verify/control" ,params});

export const getTemplateImage =(params)=>defHttp.get({ url: "/sign/file/list/image/annex" ,params});



