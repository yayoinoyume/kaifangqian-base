/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';
import type { Rule } from 'ant-design-vue/es/form';

import {sealType} from "../../seal/data"

export const registerColumns:BasicColumn[] =[
  {
    title:'印章名称',
    dataIndex:'sealName'
  },
  {
    title:'印章类型',
    dataIndex:'sealType',
    slots: { customRender: 'sealType' },
  },
  {
    title:'制作完成时间',
    dataIndex:'createTime'
  },
  {
    title:'变更',
    dataIndex:'changeCount',
    slots: { customRender: 'changeCount' },
  },
  {
    title:'停用',
    dataIndex:'stopCount'
  },
  {
    title:'收缴',
    dataIndex:'collectionCount',
    slots: { customRender: 'collectionCount' },
  },
  {
    title:'激活',
    dataIndex:'activateCount'
  },
  {
    title:'当前状态',
    dataIndex:'sealStatus',
    slots: { customRender: 'sealStatus' },
  }
]

export const registerSearchFormSchema: FormSchema[] = [
  {
    field: 'sealType',
    label: '印章类型',
    component: 'Select',
    componentProps: {
      options: [
        { label: '全部', value: "" },
        ...sealType
      ],
    },
    colProps: { span:  6 },
  },
  {
    field: 'sealName',
    label: '印章名称',
    component: 'Input',
    colProps: { span: 6 },
  },
];
