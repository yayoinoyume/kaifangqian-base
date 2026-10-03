/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';


export function getUploadFileType() {
    return defHttp.get({ url: "/sign/file/convertFlag"},{ errorMessageMode: 'none',isTransformResponse:false });
}

export function buildFileType(office){
    var defType = ['.pdf'];
    if(office){
        defType.push(".doc");
        defType.push(".docx");
        defType.push(".xls");
        defType.push(".xlsx");
    }
    return defType.join(",");
}