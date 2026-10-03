/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema  } from '/@/components/Table';

export const businessColumns:BasicColumn[] =[
  {
    title:'业务线名称',
    dataIndex:'name',
  },
  {
    title:'管理员',
    dataIndex:'managerList',
    slots: { customRender: 'managerList' },
    width:300,
  },
  {
    title:'类型',
    dataIndex:'folderName',
    width:180,
  },
  {
    title:'状态',
    dataIndex:'status',
    width:180,
    align:'center',
    slots: { 
      customRender: 'status',
    },
  },
  {
    title:'操作',
    dataIndex:'action',
    width:200,
    align:'center',
    slots: { customRender: 'action' },
  },
]


export const registerSearchFormSchema: FormSchema[] = [
  
  {
    field: 'name',
    label: '业务线名称',
    component: 'Input',
    required:false,
    colProps: { span: 8 },
  },
  {
     field: 'status',
     label: '状态',
     component: 'Select',
     colProps: { span: 8 },
     componentProps:{
       options:[
         {label:'全部',value:'0'},
         {label:'启用',value:'1'},
         {label:'停用',value:'2'},
       ]
     },
   },
  
]

