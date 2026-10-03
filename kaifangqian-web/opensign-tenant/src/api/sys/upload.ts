/*
 * @description 资助审批电子签章系统
 */

import { UploadApiResult } from './model/uploadModel';
import { defHttp } from '/@/utils/http/axios';
import { UploadFileParams } from '/#/axios';
import { useGlobSetting } from '/@/hooks/setting';


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