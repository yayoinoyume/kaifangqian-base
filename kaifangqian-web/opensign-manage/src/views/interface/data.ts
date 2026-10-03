/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';

export const authorizationColumn:BasicColumn[] = [
  {
    title:'开发者名称',
    dataIndex:'developerName',
    slots: { customRender: 'developerName' },
  },
  {
    title:'企业名称',
    width:400,
    dataIndex:'tenantName',
  },
  {
    title:'状态',
    dataIndex:'status',
    slots: { customRender: 'status' },
  },
  {
    title:'创建时间',
    dataIndex:'createTime',
  },
  {
    title:'操作',
    width:200,
    dataIndex:'action',
    slots: { customRender: 'action' },
    
  },
]

export const authorizationFormSchema:FormSchema[] = [
  {
    field: 'developerName',
    label: '开发者名称',
    component: 'Input',
    required: false,
    colProps: { span: 6 },
  },
 
  {
    field: 'status',
    label: '状态',
    component: 'Select',
    required: false,
    colProps: { span: 6 },
    componentProps:{
      options:[
        {label:'全部',value:''},
        {label:'启用',value:1},
        {label:'停用',value:0},
      ]
    }
  }
]

export const createFormSchema:FormSchema[] = [
  {
    field: 'id',
    label: '开发者简称',
    component: 'Input',
    show: false,
    colProps: { span: 22 },
  },
  {
    field: 'developerName',
    label: '开发者简称',
    component: 'Input',
    required: true,
    colProps: { span: 22 },
  },
  {
    field: 'callbackUrl',
    label: '回调地址',
    component: 'Input',
    required: true,
    colProps: { span: 22 },
  },
  {
    field: 'tenantId',
    label: '所属企业',
    component: 'Input',
    required: true,
    slot:'tenantId',
    colProps: { span: 22 },
  },
  /* {
    field: 'tenantId',
    label: '所属企业',
    component: 'ApiSelect',
    colProps: { span: 12 },
    required:true,
    slot:'tenantId',
    componentProps:{
      api: getAuthGroup,
      resultField: 'result',
      labelField:'groupName',
      valueField:'id'
    }
  }, */
  
  {
    field: 'publicKey',
    label: '公钥',
    component: 'InputTextArea',
    required: true,
    colProps: { span: 22 },
    componentProps: {
       disabled: false,
       autoSize:{ minRows: 5, maxRows: 24 }
    },
  },
   
]



