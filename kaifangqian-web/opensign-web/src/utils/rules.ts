/*
 * @description 资助审批电子签章系统
 */

import type { Rule } from 'ant-design-vue/es/form';

import { isMobile, isEmail } from '/@/utils/validate';

export const validateMobile =  (_rule: Rule, value: string) =>{
  if(!value){
    return Promise.reject('请输入手机号');
  }
  if(!isMobile(value)){
    return Promise.reject('手机号格式不正确');
  }else{
    return Promise.resolve(); 
  }
}
export const validateEmail =  (_rule: Rule, value: string) =>{
  if(!value){
    return Promise.reject('请输入邮箱');
  }
  if(!isEmail(value)){
    return Promise.reject('邮箱格式不正确');
  }else{
    return Promise.resolve(); 
  }
}
export const validatePassword =  (_rule: Rule, value: string) =>{
  if(!value){
    return Promise.reject('请输入密码');
  }
  return Promise.resolve(); 
}

export const validateSmscode = (_rule: Rule, value: string) =>{
  if(!value){
    return Promise.reject('请输入验证码');
  }
  // if(value && !/^\d{6}$/.test(value)){
  //   return Promise.reject('请输入6位数字'); 
  // }
  return Promise.resolve(); 
}
export const validateSignPssword = (_rule: Rule, value: string) =>{
  if(!value){
    return Promise.reject('请输入签署密码');
  }
  if(value && !/^\d{6}$/.test(value)){
    return Promise.reject('密码须为6位数字'); 
  }
  return Promise.resolve(); 
}
