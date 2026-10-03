/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';
import type { Rule } from 'ant-design-vue/es/form';

import {getMyTenantDeparts} from "/@/api/sys/user"
export const registerColumns:BasicColumn[] =[
  {
    title:'签名图片',
    dataIndex:'annexId',
    slots: { customRender: 'annexId' },
    width:350,
  },
  {
    title:'签名名称',
    dataIndex:'sealName'
  },

  {
    title:'创建时间',
    dataIndex:'createTime',
    slots: { customRender: 'createTime' },
    // width:200,
  },
  // {
  //   title:'是否为默认',
  //   dataIndex:'isDefault',
  //   slots: { customRender: 'isDefault' },
  //    width:100
  // },
  
  {
    title:'操作',
    dataIndex:'action',
    flag:'ACTION',
    slots: { customRender: 'action' },
    align:'center',
    // width:100
  },
]


export const signatureAuthColumns:BasicColumn[] =[
  {
    title:'授权企业',
    dataIndex:'tenantName'
  },
  {
    title:'签署业务',
    dataIndex:'signReName',
    slots: { customRender: 'signReName' }
  },
  {
    title:'授权签名',
    dataIndex:'annexId',
    slots: { customRender: 'annexId' },
  },
  {
    title:'授权截止日期',
    dataIndex:'authTime',
    slots: { customRender: 'authTime' },
    width:120,
  },
  {
    title:'授权状态',
    dataIndex:'authStatus',
    slots: { customRender: 'authStatus' },
    width:100
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


export const formSchema: FormSchema[] = [
  {
    field: 'tenantId',
    label: '授权企业',
    component: 'Select',
    slot:'folderId',
    required: true,
    labelWidth:100,
    colProps: { span: 24 },
    componentProps:{
    }
  },
]

export const registerSearchFormSchema: FormSchema[] = [];


