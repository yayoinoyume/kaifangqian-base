/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';

export const applicationColumn:BasicColumn[] = [
  {
    title:'应用',
    dataIndex:'application',
    slots: { customRender: 'application' },
  },
  {
    title:'可用范围',
    dataIndex:'auth',
    slots: { customRender: 'auth' },
  },
  {
    title:'操作',
    dataIndex:'action',
    width:180,
    slots: { customRender: 'action' },
  },
]

export const  appSearchFormSchema:FormSchema[] = [
  {
    field: 'application',
    label: '应用名称',
    component: 'Input',
    colProps: { span: 8 },
  }
]
