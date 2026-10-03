/*
 * @description 资助审批电子签章系统
 */

// import type { CollapseProps } from 'antd-design-vue/lib/collapse'


export interface CollapseProps {
  // id:string;

  // title?: string;
  // /**
  //  * collapse default prpertis
  //  */
  // collProps?:{}
  // /**
  //  * isShowChexkBox in header
  //  */
  // showCheckBox: { type: Boolean, default: false },
  // /**
  //  * header title icon
  //  */
  // icon?:string;

  // /** 
  //  * header checkbox is selected 
  //  */
  // isSelectAll?:{type: Boolean, default: false };

  isCheckedCollapsed?: {
    type:Boolean,
    default:true
  },
  // expandIconPosition?:'right'

}


