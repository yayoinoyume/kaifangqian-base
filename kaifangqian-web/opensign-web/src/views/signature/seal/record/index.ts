/*
 * @description 资助审批电子签章系统
 */

export enum SealRecordType{
  SealMake = 1,
  SealEdit = 2,
  SealChange = 3,
  SealStart = 4,
  SealStop = 5,
  SealDivested = 6,
  SealDestruction = 7,
}


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
