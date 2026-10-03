/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn, FormSchema  } from '/@/components/Table';

export const draftColumns:BasicColumn[] =[
  {
    title:'文档主题',
    dataIndex:'subject',
    
    slots: { customRender: 'subject' },
  },
  {
    title:'文档状态',
    dataIndex:'status',
    width:180,
    slots: { customRender: 'status' },
  },
  {
    title:'时间',
    dataIndex:'createTime',
    width:240,
    slots: { customRender: 'createTime' },
  },
  {
    title:'操作',
    dataIndex:'action',
    width:200,
    slots: { customRender: 'action' },
  },
]