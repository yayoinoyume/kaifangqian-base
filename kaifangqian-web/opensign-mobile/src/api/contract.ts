/**
 * @description 企业合同查询相关API
 */
import http, { Response } from '@/utils/http';

import {appHeader} from "@/api"
export default {
  async listMyJob(params: any) {
    return await http.get<Response>('/company/task/listMyJob', params,appHeader());
  },
  async listAll(params: any) {
    return await http.get<Response>('/company/task/listAll', params,appHeader());
  },
  
};
