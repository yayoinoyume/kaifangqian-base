/**
 * @description 开通个人身份、加入企业等相关API
 */
import http, { Response } from '@/utils/http';

import { appHeader } from "./"


export default {
    async openPersonalTenant() {
        return await http.put<Response>('/system/sysTenantInfo/openPersonalTenant', {}, appHeader());
    },
    async jionTenant(params: any) {
        return await http.put<Response>('/system/sysTenantInfo/jionTenant', params, appHeader());
    },
    async getImgBase64(params: any) {
        return await http.get<Response>('/file/downloadFileBase/' + params.imgId, params, appHeader());
    }
};
