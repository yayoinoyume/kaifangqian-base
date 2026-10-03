/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-20 11:09:14 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-06-20 11:14:36
 */

/**
 * 系统状态码转换
 */

export function transferRoleType(type:string|number){
  switch(Number(type)){
    case 1:
      return '总经理';
    case 2:
      return '总监';
    default:
      return '员工'
  }
}

