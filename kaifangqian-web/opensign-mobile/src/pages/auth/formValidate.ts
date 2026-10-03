/**
 * @description 云盾认证API
 */
import {isOrganizationCode ,isIdNumber, isMobile} from '@/utils/validate';

export const validateOrganizationCode =  (value: string) =>{
  if(!value){
    return "请输入组织机构代码";
  }
  if(!isOrganizationCode(value)){
    return '统一社会信用代码格式不正确';
  }
  return null;
}

export const validateIdNumber =  (value: string) =>{
  if(!value){
    return '请输入证件号';
  }
  if(!isIdNumber(value)){
    return '证件号格式不正确';
  }
  return Promise.resolve(); 
}
export const validatePhone=  (value: string) =>{
  if(!value){
    return '请输入手机号';
  }
  if(!isMobile(value)){
    return '手机号格式不正确';
  }
  return Promise.resolve(); 
}
export const validateSms=  (value: string) =>{
  if(!value){
    return '请输入验证码';
  }
  if(!(/^(?:\d{4}|\d{6})$/.test(value))){
    return '验证码格式不正确';
  }
}