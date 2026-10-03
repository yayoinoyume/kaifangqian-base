/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';

export const columns: BasicColumn[] = [
  {
    title: 'id',
    dataIndex: 'id',
    align: 'left',
  },
  {
    title: '数量',
    dataIndex: 'dataCount',
  },
  {
    title: '单价',
    dataIndex: 'dataPrice',
  },
  {
    title: '所属部门',
    dataIndex: 'sysOrgCode',
  },
  {
    title: '所属用户',
    dataIndex: 'sysUserId',
  },
  
]

export const  searchFormSchema: FormSchema[] = [
  {
    field: 'dataName',
    label: '名称',
    component: 'Input',
    colProps: { span: 8 },
  },
]