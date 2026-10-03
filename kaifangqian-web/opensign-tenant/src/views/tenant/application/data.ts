/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';

export const applicationColumn:BasicColumn[] = [
  {
    title:'应用',
    dataIndex:'appName',
    slots: { customRender: 'appName' },
  },
  {
    title:'可用范围',
    dataIndex:'appType',
    width:400,
    slots: { customRender: 'appType' },
  },
  {
    title:'操作',
    width:200,
    dataIndex:'action',
    slots: { customRender: 'action' },
  },
]

export const  appSearchFormSchema:FormSchema[] = [
  {
    field: 'appName',
    label: '应用名称',
    component: 'Input',
    colProps: { span: 8 },
  }
]
