/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';

export const certicifateColumn:BasicColumn[] = [
  {
    title:'颁发时间',
    dataIndex:'issueTime',
  },
  {
    title:'证书序列号',
    dataIndex:'certSuqeNo',
  },
  {
    title:'使用者',
    dataIndex:'userName',
  },
  {
    title:'证书类型',
    dataIndex:'certType',
    slots: { customRender: 'certType' },
  },
  {
    title:'颁发机构',
    dataIndex:'issueOrg',
  },
  {
    title:'加密算法',
    dataIndex:'algorithmType',
    slots: { customRender: 'algorithmType' },
  },
  // {
  //   title:'存储介质',
  //   dataIndex:'storageMedium',
  // },
  {
    title:'状态',
    dataIndex:'certStatus',
    slots: { customRender: 'certStatus' },
  },
  {
    title:'有效期',
    dataIndex:'cerRange',
    slots: { customRender: 'cerRange' },
  },
  
]

export const certificateSearchFormSchema:FormSchema[] = [
  {
    field: 'userName',
    label: '使用者名称',
    component: 'Input',
    required: false,
    colProps: { span: 6 },
  },
  {
    field: 'certType',
    label: '证书类型',
    component: 'Select',
    required: false,
    colProps: { span: 6 },
    componentProps:{
      options:[
        {label:'全部',value:''},
        {label:'平台防篡改证书',value:1},
        {label:'测试数字证书',value:2},
        {label:'CA事件数字证书',value:3},
        {label:'CA长效数字证书',value:4},
      ]
    }
  },
  {
    field: 'certStatus',
    label: '状态',
    component: 'Select',
    required: false,
    colProps: { span: 6 },
    componentProps:{
      options:[
        {label:'全部',value:''},
        {label:'有效',value:1},
        // {label:'吊销',value:2},
        {label:'失效',value:3},
      ]
    }
  },
  {
    field: 'promulgateTime',
    label: '颁发时间',
    component: 'RangePicker',
    required: false,
    colProps: { span: 6 },
  },
  {
    field: 'invalidTime',
    label: '失效时间',
    component: 'RangePicker',
    required: false,
    colProps: { span: 6 },
  },
]

export const certificateEntSearchFormSchema:FormSchema[] = [
  {
    field: 'userName',
    label: '使用者名称',
    component: 'Input',
    required: false,
    colProps: { span: 6 },
  },
  {
    field: 'certType',
    label: '证书类型',
    component: 'Select',
    required: false,
    colProps: { span: 6 },
    componentProps:{
      options:[
        {label:'全部',value:''},
        {label:'平台防篡改证书',value:1},
        {label:'测试数字证书',value:2},
        {label:'CA事件数字证书',value:3},
        {label:'CA长效数字证书',value:4},
      ]
    }
  },
  {
    field: 'certStatus',
    label: '状态',
    component: 'Select',
    required: false,
    colProps: { span: 6 },
    componentProps:{
      options:[
        {label:'全部',value:''},
        {label:'有效',value:1},
        // {label:'吊销',value:2},
        {label:'失效',value:3},
      ]
    }
  },
  {
    field: 'promulgateTime',
    label: '颁发时间',
    component: 'RangePicker',
    required: false,
    colProps: { span: 6 },
  },
  {
    field: 'invalidTime',
    label: '失效时间',
    component: 'RangePicker',
    required: false,
    colProps: { span: 6 },
  },
]



