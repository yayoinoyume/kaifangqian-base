/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';

export const tableColumn:BasicColumn[] = [
  {
    title:'法人单位名称',
    dataIndex:'name',
  },
  // {
  //   title:'法定代表人',
  //   dataIndex:'corporation',
  // },
  // {
  //   title:'认证类型',
  //   dataIndex:'authType',
  //   slots: { customRender: 'authType' },
  // },
  {
    title:'事项',
    dataIndex:'realItem',
    slots: { customRender: 'realItem' },
  },
  // {
  //   title:'申请人',
  //   dataIndex:'applyUser',
  // },
  {
    title:'申请时间',
    dataIndex:'applyTime',
  },
  {
    title:'审核状态',
    dataIndex:'authStatus',
    slots: { customRender: 'authStatus' },
  },
  {
    title:'审核人',
    dataIndex:'checkUser',
  },
  {
    title:'操作',
    dataIndex:'action',
    
    slots: { customRender: 'action' },
  },
  
]

export const tableSearchFormSchema:FormSchema[] = [
  {
    field: 'name',
    label: '法人单位名称',
    component: 'Input',
    required: false,
    colProps: { span: 6 },
  },
  

  {
    field: 'applyTime',
    label: '时间',
    component: 'RangePicker',
    required: false,
    colProps: { span: 6 },
    componentProps: {
      // format: 'YYYY-MM-DD HH:mm:ss',
      placeholder: ['开始时间', '结束时间'],
    },
  },
]
export const rejcetFormSchema:FormSchema[] = [
  {
    field: 'checkMsg',
    label: '驳回原因',
    component: 'InputTextArea',
    required: true,
    colProps: { span: 24 },
    componentProps:{
      autoSize:{ minRows: 8, maxRows: 34 }
    }
  },
]

