/*
 * @description 资助审批电子签章系统
 */


export interface CollPaseSchema {
  id:string;

  title:string;

  isChecked?:boolean;

  children?: any;

  icon?:string;
}