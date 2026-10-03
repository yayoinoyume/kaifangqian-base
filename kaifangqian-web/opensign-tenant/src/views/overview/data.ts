/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';

export const memberJoinColumn:BasicColumn[] = [
  {
    title:'申请人',
    dataIndex:'nickName',
  },
  {
    title:'手机号',
    dataIndex:'phone',
  },
  {
    title:'邮箱',
    dataIndex:'email',
  },
  {
    title:'申请时间',
    dataIndex:'applyTime',
  },
  {
    title:'审核状态',
    dataIndex:'status',
    slots: { customRender: 'status' },
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
  },
  
]
export const recordColumn:BasicColumn[] = [
  {
    title:'法人单位名称',
    dataIndex:'name',
  },
  {
    title:'法定代表人',
    dataIndex:'corporation',
  },
  {
    title:'认证类型',
    dataIndex:'authType',
    slots: { customRender: 'authType' },
  },
  {
    title:'事项',
    dataIndex:'realItem',
    slots: { customRender: 'realItem' },
  },
  {
    title:'申请人',
    dataIndex:'applyUser',
  },
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
    title:'审核时间',
    dataIndex:'checkTime',
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
  },
  
]