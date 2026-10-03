/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';

export const tableOperateColumns:BasicColumn[] =[
  {
    title:'操作人',
    dataIndex:'sysTenantUserName'
  },
  {
    title:'操作时间',
    dataIndex:'operateTime'
  },
  {
    title:'操作事项',
    dataIndex:'operateName',
  }
]

export const tableApproveColumns:BasicColumn[] =[
  {
    title:'申请人',
    dataIndex:'sysTenantUserName'
  },
  {
    title:'申请时间',
    dataIndex:'applyTime',
  },
  {
    title:'申请类型',
    dataIndex:'operateName',
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

export const tableUseColumns:BasicColumn[] =[
  {
    title:'系统授权标识',
    dataIndex:'sealName'
  },
  {
    title:'调用时间',
    dataIndex:'sealType',
    slots: { customRender: 'sealType' },
  },
]


export const ProcessApplyState = [
  {
    value:1,
    label:'待提交'
  },
  {
    value:2,
    label:'待重新提交'
  },
  {
    value:3,
    label:'待审批'
  },
  {
    value:4,
    label:'审批未通过'
  },
  {
    value:5,
    label:'审批通过'
  },
  {
    value:6,
    label:'作废'
  },
]
export const getProcessApplyState=(value:number)=>{
  	let result =  ProcessApplyState.filter((item:any) => {
  			return item.value == value 
  	})[0]
    if(result){
      return result;
    }else{
      return {};
    }
}
