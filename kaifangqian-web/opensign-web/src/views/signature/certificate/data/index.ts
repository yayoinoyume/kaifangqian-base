/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';
import type { Rule } from 'ant-design-vue/es/form';


export const registerColumns:BasicColumn[] =[
  {
    title:'颁发时间',
    dataIndex:'issueTime'
  },
  {
    title:'证书序列号',
    dataIndex:'certSuqeNo'
  },
  {
    title:'使用者',
    dataIndex:'sysTenantUserName'
  },
  {
    title:'证书类型',
    dataIndex:'holderType',
    slots: { customRender: 'holderType' },
  },
  {
    title:'颁发机构',
    dataIndex:'issue'
  },
  {
    title:'加密算法',
    dataIndex:'algorithmType',
    slots: { customRender: 'algorithmType' },
  },
  {
    title:'存储介质',
    dataIndex:'storageMedium'
  },
  {
    title:'状态',
    dataIndex:'validateStatus',
    slots: { customRender: 'validateStatus' },
  },
  {
    title:'有效期',
    dataIndex:'templateTitle',
    slots: { customRender: 'validityTime' },
  },
  {
    title:'操作',
    dataIndex:'action',
    flag:'ACTION',
    slots: { customRender: 'action' },
    align:'center',
    width:100
  },
]

export const registerSearchFormSchema: FormSchema[] = [
  {
    field: 'holderName',
    label: '使用者',
    component: 'Input',
    colProps: { span: 6 },
  },
  
  {
    field: 'holderType',
    label: '证书类型',
    component: 'Select',
    componentProps: {
      options: [
        { label: '个人', value: 1 },
        { label: '企业', value: 2 },
        
      ],
    },
    colProps: { span:  6 },
  },
  {
    field: 'validateStatus',
    label: '证书状态',
    component: 'Select',
    componentProps: {
      options: [
        { label: '有效', value: 1 },
        { label: '失效', value: 2 },
      ],
    },
    colProps: { span:  6 },
  },
];
