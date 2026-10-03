/*
 * @description 资助审批电子签章系统
 */

import { UploadApiResult } from './model/uploadModel';
import { defHttp } from '/@/utils/http/axios';
import { UploadFileParams } from '/#/axios';
import { useGlobSetting } from '/@/hooks/setting';
import { getToken } from '/@/utils/auth';
import { getAppEnvConfig } from '/@/utils/env';
enum Api {
  ImgBase64 = '/file/downloadFileBase',
  FileStream = '/file/downloadFileStream',
  FileByte = '/file/downloadFileByte',
}


const { uploadUrl = '/file',uploadAvatarUrl } = useGlobSetting();
console.log(uploadUrl,uploadAvatarUrl,'路径上传-----')
/**
 * @description: Upload interface
 */
export function uploadAvatarApi(
  params: UploadFileParams,
  onUploadProgress: (progressEvent: ProgressEvent) => void,
) {
  return defHttp.uploadFile<UploadApiResult>(
    {
      url: uploadAvatarUrl,
      onUploadProgress,
    },
    params,
  );
}
/**
 * @description: Upload interface
 */
export function uploadApi(
  params: UploadFileParams,
  onUploadProgress: (progressEvent: ProgressEvent) => void,
) {
  return defHttp.uploadFile<UploadApiResult>(
    {
      url: uploadUrl,
      onUploadProgress,
    },
    params,
  );
}

export function getImgBase64(params) {
  return defHttp.get({ url: Api.ImgBase64 + '/'+ params.imgId , params });
}

export function getImgStream(params) {
  return defHttp.get({ url: Api.ImgStream + '/'+ params.imgId , params, headers: 
  {
    responseType: 'blob'
  }, });
}


export function getFileStrem(params) {
  return defHttp.get({ url: Api.FileStream + '/'+ params.fileId , params, headers: 
  {
    responseType: 'blob',
    // responseType: 'arraybuffer',
  }, 
});
}

export function getFileArrayBuffer(params) {
  return defHttp.get({ url: Api.FileByte + '/'+ params.fileId , params, headers: 
  {
    responseType: 'blob',
    // responseType: 'arraybuffer',
  }, 
});
}
export function downloadFile(record){
    
      // defHttp.get({ url: Api.FileStream + '/'+ record.id , headers:{responseType: 'blob' }}).then(res=>{
      //    const blob = new Blob([res.data.data], { type: 'application/octet-stream;charset=utf-8' });
      //    console.log(typeof(res.data.data));
      //    let dom:any = document.createElement('a')
      //    let url = window.URL.createObjectURL(blob)
      //    dom.href = url
      //    dom.download = decodeURI("123.pdf")
      //    dom.style.display = 'none'
      //    document.body.appendChild(dom)
      //    dom.click()
      //    dom.parentNode.removeChild(dom)
      //    window.URL.revokeObjectURL(url)
      // })
      let {VITE_GLOB_APP_CODE,VITE_GLOB_API_URL} = getAppEnvConfig()
      const token:string = getToken() as string;
      const req = new XMLHttpRequest();
      req.open('GET', window.location.origin + VITE_GLOB_API_URL + '/file/downloadFileStream/'+ record.id, true);
      req.responseType = 'blob';
      req.setRequestHeader('X-Access-Token',token);
      req.setRequestHeader('resrun-app-code',VITE_GLOB_APP_CODE);
      req.onload = function() {
        const data = req.response;
        const blob = new Blob([data], { type: 'application/octet-stream' });
        let dom:any = document.createElement('a')
        let url = window.URL.createObjectURL(blob)
        dom.href = url
        dom.download = decodeURI(record.realName)
        dom.style.display = 'none'
        document.body.appendChild(dom)
        dom.click()
        dom?.parentNode.removeChild(dom)
        window.URL.revokeObjectURL(url)
      };
      req.send();
      
}
