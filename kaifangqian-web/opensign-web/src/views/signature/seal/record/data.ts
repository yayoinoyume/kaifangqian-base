/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { getAuthGroup } from '/@/api/auth/group'; 



export const tableSealDivestedColumns:BasicColumn[] =[
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
    title:'申请人',
    dataIndex:'applierName'
  },
  {
    title:'申请时间',
    dataIndex:'applyTime'
  },
  {
    title:'状态',
    dataIndex:'applyStatus',
    slots: { customRender: 'applyStatus' },
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
    flag:'ACTION',
    align:'center',
  },
]

export const tableSealMakeColumns:BasicColumn[] =[
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
    title:'制作方式',
    dataIndex:'createType',
    slots: { customRender: 'createType' },
  },
  {
    title:'申请人',
    dataIndex:'applierName'
  },
  {
    title:'申请时间',
    dataIndex:'applyTime'
  },
  {
    title:'状态',
    dataIndex:'applyStatus',
    slots: { customRender: 'applyStatus' },
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
    flag:'ACTION',
    align:'center',
  },
]

export const tableSealStateColumns:BasicColumn[] =[
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
    title:'操作类型',
    dataIndex:'operateType',
    slots: { customRender: 'operateType' },
  },
  {
    title:'申请人',
    dataIndex:'applierName'
  },
  {
    title:'申请时间',
    dataIndex:'applyTime'
  },
  {
    title:'状态',
    dataIndex:'applyStatus',
    slots: { customRender: 'applyStatus' },
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
    flag:'ACTION',
    align:'center',
  },
]

export const tableSealEditColumns:BasicColumn[] =[
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
    title:'操作人',
    dataIndex:'applierName'
  },
  {
    title:'操作时间',
    dataIndex:'applyTime'
  },
]

export const SealMakeData = [
  {
    sealName:"发票专用章",
    sealType:"1",
    applierName:"admin",
    applyTime:"2023年8月17日19:27:05",
    sealStatus:"申请中",
  }
]
