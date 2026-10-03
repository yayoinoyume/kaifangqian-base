/*
 * @description 资助审批电子签章系统
 */

/**
 * 此处可直接引用自己项目封装好的 axios 配合后端联调
 */

// import request from './../utils/axios'; //组件内部封装的axios
// import request from "@/api/axios.js"       //调用项目封装的axios
import { defHttp } from '@/utils/http/axios';

//获取验证图片  以及token
export function reqGet(data) {
  return defHttp.post({ url: '/captcha/get', data }, { isTransformResponse: false });
}

//滑动或者点选验证
export function reqCheck(data) {
  return defHttp.post({ url: '/captcha/check', data }, { isTransformResponse: false });
}
