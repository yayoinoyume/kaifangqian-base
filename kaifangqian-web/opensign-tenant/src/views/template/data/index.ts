/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';
import type { Rule } from 'ant-design-vue/es/form';


export const docState = [
  {label:'制作中',value:'1',"color":"#fec03d"},
  {label:'制作失败',value:'2',"color":"#f56c6c"},
  {label:'停用',value:'3',"color":"#52c1f5"},
  {label:'启用',value:'4',"color":"#19be6B"},
]


export const getDocStat =(value:string)=>{
  return   docState.find((item)=>{
    return item.value == value;
  });
}
export const registerColumns:BasicColumn[] =[
/*  {
    title:'模板编号',
    dataIndex:'templateCode',
    slots:{customRender:'templateCode'}
  }, */
  {
    title:'模板名称',
    dataIndex:'templateName',
    slots:{customRender:'templateName'}
  },
  {
    title:'模板参数',
    dataIndex:'templateType',
    width:100,
    slots:{customRender:'templateType'}
  },
 {
    title:'最后修改时间',
    dataIndex:'updateTime',
    width:150,
    slots:{customRender:'updateTime'}
  },
  {
    title:'模板状态',
    dataIndex:'templateStatus',
    width:100,
    slots:{customRender:'templateStatus'}
  },
  {
    title:'操作',
    width:400,
    dataIndex:'action',
    slots: { customRender: 'action' },
  },
]


export const registerSearchFormSchema: FormSchema[] = [
  
  {
    field: 'templateCode',
    label: '模板编号',
    component: 'Input',
    required:false,
    colProps: { span: 8 },
  },
  {
    field: 'templateName',
    label: '模板名称',
    component: 'Input',
    required:false,
    colProps: { span: 8 },
  },
  {
     field: 'templateType',
     label: '有无参数',
     component: 'Select',
     colProps: { span: 8 },
     componentProps:{
       options:[
         {label:'全部',value:'-1'},
         {label:'有参数',value:'1'},
         {label:'无参数',value:'2'},
       ]
     }
   },
 
  {
    field: 'templateStatus',
    label: '模板状态',
    component: 'Select',
    colProps: { span: 8 },
    componentProps:{
      options:[
        {label:'全部',value:'-1'},
        ...docState
      ]
    }
  },
  
]
