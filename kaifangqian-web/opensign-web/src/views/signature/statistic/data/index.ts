/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema } from '/@/components/Table';
import type { Rule } from 'ant-design-vue/es/form';

// import {businessType} from "../../doc/data"

export const registerColumns:BasicColumn[] =[
  {
    title:'部门',
    dataIndex:'useSealDept'
  },
  {
    title:'业务类型',
    dataIndex:'businessType'
  },
  {
    title:'用印方式',
    dataIndex:'useSealWay'
  },
  {
    title:'加盖印章类型',
    dataIndex:'sceneType',
    slots: { customRender: 'sceneType' },
  },
  {
    title:'印章类型',
    dataIndex:'sealType'
  },
  {
    title:'用印次数',
    dataIndex:'useSealCount',
    slots: { customRender: 'useSealCount' },
  },
]

export const registerSearchFormSchema: FormSchema[] = [
  {
    field: 'sealType',
    label: '用印部门',
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
    field: 'sealType',
    label: '业务类型',
    component: 'Select',
    componentProps: {
      options: [
        { label: '全部', value: "" },
        // ...businessType
      ],
    },
    colProps: { span:  6 },
  },
  {
    field: 'recordTime',
    label: '时间范围',
    component: 'RangePicker',
    required:false,
    colProps: { span: 6 },
  }
];
