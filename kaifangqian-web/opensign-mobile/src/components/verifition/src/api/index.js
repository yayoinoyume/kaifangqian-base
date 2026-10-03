/**
 * @description 动态图标验证
 */

/**
 * 此处可直接引用自己项目封装好的 axios 配合后端联调
 */

// import request from './../utils/axios'; //组件内部封装的axios
// import request from "@/api/axios.js"       //调用项目封装的axios
// import { defHttp } from '@/utils/http/axios';
import http from '@/utils/http';

//获取验证图片  以及token
export function reqGet(data) {
  return http.post('/captcha/get', data);
}

//滑动或者点选验证
export function reqCheck(data) {
  return http.post('/captcha/check', data);
}
